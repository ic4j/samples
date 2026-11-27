"""Run the packaged Samples route, with fresh local Kafka and LoanProvider."""
import json
import os
import re
import socket
import subprocess
import sys
import time
from contextlib import ExitStack
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
TOPIC = "ic4j-samples-loan-smoke"
GROUP = "ic4j-samples-loan-ci"
LOAN = {
    "id": 1, "firstname": "Local", "lastname": "Smoke", "zipcode": "00000",
    "ssn": "synthetic", "amount": 10.5, "term": 12, "created": 0,
}


def run(*args, timeout=25, check=True):
    return subprocess.run(args, text=True, capture_output=True, timeout=timeout, check=check)


def await_result(description, timeout, probe, processes):
    deadline = time.monotonic() + timeout
    while time.monotonic() < deadline:
        for name, process in processes:
            if process.poll() is not None:
                raise RuntimeError(f"{name} exited early ({process.returncode})")
        try:
            value = probe()
        except subprocess.TimeoutExpired:
            value = None
        if value:
            return value
        time.sleep(1)
    raise RuntimeError(f"Timed out waiting for {description}; see logs")


def stop(process):
    if process.poll() is None:
        process.terminate()
        try:
            process.wait(timeout=10)
        except subprocess.TimeoutExpired:
            process.kill()
    process.wait()


def verify(project, port, canister, candid):
    work = Path(project).parent
    reports = Path(os.environ.get("KAFKA_REPORTS", work / "reports"))
    reports.mkdir(parents=True, exist_ok=True)
    kafka = Path(os.environ["KAFKA_HOME"]).resolve() / "bin"
    target = ROOT / "IC4JCamelSample" / "target"
    jar, = target.glob("ic4j-sample-camel-*.jar")
    env = dict(os.environ, KAFKA_HEAP_OPTS="-Xms128m -Xmx384m")

    with socket.socket() as broker_port, socket.socket() as controller_port:
        broker_port.bind(("127.0.0.1", 0))
        controller_port.bind(("127.0.0.1", 0))
        broker = f"127.0.0.1:{broker_port.getsockname()[1]}"
        controller = f"127.0.0.1:{controller_port.getsockname()[1]}"

    config = work / "broker.properties"
    config.write_text(f"""process.roles=broker,controller
node.id=1
controller.quorum.voters=1@{controller}
listeners=PLAINTEXT://{broker},CONTROLLER://{controller}
advertised.listeners=PLAINTEXT://{broker}
controller.listener.names=CONTROLLER
listener.security.protocol.map=CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT
inter.broker.listener.name=PLAINTEXT
num.partitions=1
offsets.topic.replication.factor=1
transaction.state.log.replication.factor=1
transaction.state.log.min.isr=1
group.initial.rebalance.delay.ms=0
auto.create.topics.enable=false
log.dirs={work / "kafka-data"}
""")
    cluster = run(kafka / "kafka-storage.sh", "random-uuid").stdout.strip()
    run(kafka / "kafka-storage.sh", "format", "-t", cluster, "-c", config)
    app = work / "app"
    inbox = app / "src" / "data"
    inbox.mkdir(parents=True)
    (app / "application.properties").write_text(f"""ic.location=http://127.0.0.1:{int(port)}
ic.canister={canister}
ic.fetchRootKey=true
kafka.brokers={broker}
kafka.topic={TOPIC}
kafka.groupId={GROUP}
camel.main.routes-include-pattern=routes/kafka-ic-route.camel.yaml
""")

    def offers():
        return run("icp", "canister", "call", "--identity", "anonymous", canister,
                   "getOffers", "()", "--query", "--candid", candid, "--output", "candid",
                   "--network", "local", "--project-root-override", project,
                   timeout=5).stdout.strip()

    if not re.fullmatch(r"\(\s*vec\s*\{\s*}\s*,?\s*\)", offers()):
        raise RuntimeError("LoanProvider was not empty before the test")

    with ExitStack() as stack:
        processes = []

        def launch(name, args, cwd):
            log = stack.enter_context((reports / f"{name}.log").open("wb"))
            process = subprocess.Popen(args, cwd=cwd, env=env, stdout=log,
                                       stderr=subprocess.STDOUT)
            stack.callback(stop, process)
            processes.append((name, process))

        launch("broker", [kafka / "kafka-server-start.sh", config], work)
        admin = [kafka / "kafka-topics.sh", "--bootstrap-server", broker]
        await_result("Kafka broker", 60,
                     lambda: run(*admin, "--list", timeout=5, check=False).returncode == 0,
                     processes)
        run(*admin, "--create", "--topic", TOPIC, "--partitions", "1", "--replication-factor", "1")

        # The first classpath entry supplies only the generated properties; the
        # route and Java classes come unchanged from the packaged sample jar.
        launch("sample", ["java", "-cp", f"{app}:{jar}:{target / 'libs'}/*",
                         "org.ic4j.samples.camel.CamelMain"], app)
        (app / "loan.json").write_text(json.dumps(LOAN))
        (app / "loan.json").rename(inbox / "loan.json")

        def committed_offset():
            result = run(kafka / "kafka-consumer-groups.sh", "--bootstrap-server", broker,
                         "--describe", "--group", GROUP, check=False, timeout=8)
            (reports / "offsets.txt").write_text(result.stdout + result.stderr)
            rows = [line.split() for line in result.stdout.splitlines()]
            return [
                row for row in rows
                if row[:3] == [GROUP, TOPIC, "0"]
                and len(row) >= 6 and all(n.isdecimal() for n in row[3:6])
                and row[3:6] == ["1", "1", "0"]
            ] or None

        (row,) = await_result("committed Kafka offset", 90, committed_offset, processes)

        def loan_offer():
            value = offers()
            (reports / "offers.candid").write_text(value + "\n")
            return value if re.search(r"\brecord\b", value) else None

        result = await_result("LoanProvider offer", 30, loan_offer, processes)
        if (len(re.findall(r"\brecord\b", result)) != 1
                or not re.search(r"\bapplicationid\s*=\s*1\s*:\s*nat\b", result)
                or not re.search(r'\bprovidername\s*=\s*"Loan Provider"', result)
                or f'principal "{canister}"' not in result):
            raise RuntimeError(f"Unexpected LoanProvider result: {result}")
        print("PASS: one Kafka record committed, zero lag; getOffers returned one Loan Provider offer")


if __name__ == "__main__":
    try:
        verify(*sys.argv[1:])
    except subprocess.CalledProcessError as error:
        sys.stderr.write((error.stdout or "") + (error.stderr or ""))
        raise
