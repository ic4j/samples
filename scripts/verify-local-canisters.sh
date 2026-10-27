#!/usr/bin/env bash
# Build sample Motoko canisters with the installed DFX compiler and test them on
# a disposable, loopback-only ICP CLI managed network. No sample properties,
# user identity files, or pre-existing .dfx state are read or written.
set -euo pipefail

ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
WORK="$(mktemp -d "${TMPDIR:-/tmp}/ic4j-samples-local.XXXXXX")"
NETWORK_STARTED=0

port_is_open() {
  python3 - "$PORT" <<'PY'
import socket, sys
s = socket.socket()
s.settimeout(0.25)
try:
    s.connect(("127.0.0.1", int(sys.argv[1])))
except OSError:
    sys.exit(1)
else:
    sys.exit(0)
finally:
    s.close()
PY
}

stop_leftover_pocketic() {
  local pids pid owner command attempt
  if ! port_is_open; then
    return 0
  fi
  if ! command -v lsof >/dev/null 2>&1; then
    echo "Loopback port $PORT is still open and lsof is unavailable; preserving $WORK" >&2
    return 1
  fi
  pids="$(lsof -nP -t -iTCP:"$PORT" -sTCP:LISTEN 2>/dev/null || true)"
  if [[ -z "$pids" || "$pids" == *$'\n'* ]]; then
    echo "Cannot identify one exact listener on loopback port $PORT; preserving $WORK" >&2
    return 1
  fi
  pid="$pids"
  owner="$(ps -p "$pid" -o user= 2>/dev/null | tr -d '[:space:]')"
  command="$(ps -p "$pid" -o command= 2>/dev/null || true)"
  if [[ "$owner" != "$(id -un)" || "$command" != *pocket-ic* || "$command" != *--port-file* ]]; then
    echo "Refusing to stop unexpected listener on loopback port $PORT; preserving $WORK" >&2
    return 1
  fi
  kill -TERM "$pid"
  for attempt in 1 2 3 4 5 6 7 8 9 10; do
    if ! port_is_open; then
      return 0
    fi
    sleep 0.5
  done
  echo "PocketIC still listens on loopback port $PORT; preserving $WORK" >&2
  return 1
}

cleanup() {
  local safe_to_remove=1
  if [[ "$NETWORK_STARTED" == 1 ]]; then
    icp network stop local --project-root-override "$WORK/icp" >/dev/null 2>&1 || true
    stop_leftover_pocketic || safe_to_remove=0
  fi
  if [[ "$safe_to_remove" == 1 ]]; then
    rm -rf "$WORK"
  else
    echo "Temporary project retained for safe cleanup: $WORK" >&2
  fi
}
trap cleanup EXIT
trap 'exit 130' INT
trap 'exit 143' TERM

for tool in dfx icp python3; do
  command -v "$tool" >/dev/null || { echo "Missing required tool: $tool" >&2; exit 2; }
done

# Pick an unused gateway port; the managed network is explicitly loopback-bound.
PORT="$(python3 - <<'PY'
import socket
s = socket.socket()
s.bind(('127.0.0.1', 0))
print(s.getsockname()[1])
s.close()
PY
)"

python3 - "$ROOT" "$WORK" "$PORT" <<'PY'
import json, shutil, sys
from pathlib import Path
root, work, port = Path(sys.argv[1]), Path(sys.argv[2]), int(sys.argv[3])
# Sources intentionally limited to checked-in sample Motoko actors.
items = {
    'webSocketHello': 'IC4JWSSample/hello/src/hello/main.mo',
    'camelLoan': 'IC4JCamelSample/src/main.mo',
    'swiftBackend': 'IC4JSwiftSample/src/motoko/main.mo',
    'androidHello': 'AndroidHelloWorld/main.mo',
    'ic4jHello': 'IC4JHelloWorld/src/main.mo',
    'advancedHello': 'IC4JHelloWorldAdvanced/src/main.mo',
    'identityHello': 'IC4JIdentitySample/src/main.mo',
    'imageStore': 'IC4JImageSample/src/main.mo',
    'jaxbLoan': 'IC4JJAXBSample/src/main.mo',
    'jdbcCredit': 'IC4JJDBCSample/src/main.mo',
    'gsonLoan': 'IC4JGsonSample/src/main.mo',
    'jacksonLoan': 'IC4JJacksonSample/src/main.mo',
    'java17Loan': 'IC4JJava17Sample/src/main.mo',
    'pojoLoan': 'IC4JPojoSample/src/main.mo',
    'springHello': 'IC4JSpringSample/src/main.mo',
    'xmlLoan': 'IC4JXMLSample/src/main.mo',
}
dfx = work / 'dfx'
dfx.mkdir(parents=True)
canisters = {}
for name, rel in items.items():
    dest = Path('src') / name / 'main.mo'
    (dfx / dest).parent.mkdir(parents=True, exist_ok=True)
    shutil.copyfile(root / rel, dfx / dest)
    if name == 'swiftBackend':
        for module in (root / 'IC4JSwiftSample/src/motoko').glob('*.mo'):
            if module.name != 'main.mo':
                shutil.copyfile(module, (dfx / dest).parent / module.name)
    canisters[name] = {'type': 'motoko', 'main': str(dest)}
(dfx / 'dfx.json').write_text(json.dumps({
    'version': 1,
    'canisters': canisters,
    'networks': {'local': {'bind': '127.0.0.1:4943', 'type': 'ephemeral'}},
}, indent=2) + '\n')

icp = work / 'icp'
icp.mkdir(parents=True)
(icp / 'icp.yaml').write_text(
    'networks:\n'
    '  - name: local\n'
    '    mode: managed\n'
    '    gateway:\n'
    '      bind: 127.0.0.1\n'
    f'      port: {port}\n'
)
PY

# Compile only; deployment below always targets the explicit managed `local` network.
(cd "$WORK/dfx" && dfx build --all --check --network local)
mkdir -p "$WORK/ids"

NETWORK_STARTED=1
icp network start local --project-root-override "$WORK/icp" --background
STATUS="$(icp network status local --project-root-override "$WORK/icp" --json)"
python3 - "$STATUS" <<'PY'
import json, sys, urllib.parse
status = json.loads(sys.argv[1])
for key in ('api_url', 'gateway_url'):
    host = urllib.parse.urlparse(status[key]).hostname
    if host not in ('localhost', '127.0.0.1', '::1'):
        raise SystemExit(f'Refusing non-loopback {key}: {status[key]}')
print(f"Verified managed local network: {status['api_url']}")
PY
icp network ping local --project-root-override "$WORK/icp" >/dev/null

# Install each compiled actor on an unlinked temporary canister. Every operation
# uses the local network name; no network URL is read from sample properties.
for name in webSocketHello camelLoan swiftBackend androidHello ic4jHello advancedHello identityHello imageStore jaxbLoan jdbcCredit gsonLoan jacksonLoan java17Loan pojoLoan springHello xmlLoan; do
  id="$(icp canister create --detached --network local --project-root-override "$WORK/icp" --quiet)"
  printf '%s\n' "$id" > "$WORK/ids/$name"
  wasm="$WORK/dfx/.dfx/local/canisters/$name/$name.wasm"
  icp canister install "$id" --wasm "$wasm" --mode install --yes --network local --project-root-override "$WORK/icp" >/dev/null
  printf 'deployed %-16s %s\n' "$name" "$id"
done

call() {
  local name="$1" method="$2" args="$3" mode="${4:-}"
  local id
  id="$(cat "$WORK/ids/$name")"
  if [[ "$mode" == query ]]; then
    icp canister call "$id" "$method" "$args" --query --candid "$WORK/dfx/.dfx/local/canisters/$name/$name.did" --network local --project-root-override "$WORK/icp" >/dev/null
  else
    icp canister call "$id" "$method" "$args" --candid "$WORK/dfx/.dfx/local/canisters/$name/$name.did" --network local --project-root-override "$WORK/icp" >/dev/null
  fi
  printf 'passed   %-16s %s\n' "$name" "$method"
}

for name in webSocketHello androidHello ic4jHello advancedHello springHello identityHello; do
  call "$name" greet '("ic4j offline smoke")'
done
call webSocketHello peek '()' query
call advancedHello peek '()' query
call identityHello getName '()' query

loan='(record { id = 1; firstname = "Local"; lastname = "Smoke"; zipcode = "00000"; ssn = "synthetic"; amount = 10.5; term = 12; created = 0 })'
for name in camelLoan gsonLoan jacksonLoan java17Loan pojoLoan xmlLoan jaxbLoan; do
  call "$name" apply "$loan"
done
for name in camelLoan gsonLoan jacksonLoan java17Loan pojoLoan xmlLoan; do
  call "$name" getOffers '()' query
done
call jdbcCredit setCredit '(record { ssn = "synthetic"; rating = 42 })'
call imageStore add '("synthetic", vec { 0; 1; 2; 255 })'
call imageStore get '("synthetic")' query
swift='(record { CdtTrfTxInf = vec {}; GrpHdr = record { CreDtTm = 0; MsgId = "local-smoke"; NbOfTxs = "0"; SttlmInf = record { SttlmMtd = variant { CLRG } } } })'
call swiftBackend reversalRequest "$swift"

echo 'All local sample canister smoke calls passed.'
