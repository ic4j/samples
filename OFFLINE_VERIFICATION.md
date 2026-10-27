# IC4J Samples local verification

## Tooling

- `icp` CLI 1.7.0 (DFINITY stable release)
- `icp-cli-network-launcher` / PocketIC 16.1.0 (`v16.1.0-2026-10-16-03-29`)
- `dfx` 0.32.0, already the latest stable DFINITY SDK release; DFINITY marks `dfx` deprecated
- `dfxvm` 1.0.2
- Java runtime used for local Java-client integration: OpenJDK 21.0.2

Installed sources: [dfinity/icp-cli releases](https://github.com/dfinity/icp-cli/releases), [dfinity/sdk releases](https://github.com/dfinity/sdk/releases), [dfinity/dfxvm releases](https://github.com/dfinity/dfxvm/releases).

## Repeatable local smoke workflow

Run:

```sh
scripts/verify-local-canisters.sh
```

The script copies checked-in Motoko sources and the Swift modules into a unique temporary project, runs `dfx build --all --check`, starts an ICP CLI managed network on a dynamically chosen gateway port with `gateway.bind: 127.0.0.1`, verifies the reported API and gateway hosts are loopback, and deploys temporary canisters there. It then executes 26 synthetic UPDATE/QUERY calls over the sample methods. It uses the CLI’s anonymous local development identity, reads no sample `application.properties`, and never targets a named public network. Its exit trap stops only its managed local network and removes only its newly created temporary directory.

The most recent run compiled and installed all 16 source-backed sample canisters and passed all 26 calls on `http://localhost:61865/` (gateway bound to `127.0.0.1`; PocketIC 16.1.0). The network and its state were stopped and removed after the run. The IDs below are retained as evidence; they no longer refer to a running network.

| Canister | Temporary canister ID |
| --- | --- |
| webSocketHello | `4caro-hl777-77775-aaaba-cai` |
| camelLoan | `4fbx2-kt777-77775-aaabq-cai` |
| swiftBackend | `4qggx-l3777-77775-aaaca-cai` |
| androidHello | `4xhad-gd777-77775-aaacq-cai` |
| ic4jHello | `46el7-ql777-77775-aaada-cai` |
| advancedHello | `4zfnl-5t777-77775-aaadq-cai` |
| identityHello | `5uljf-s3777-77775-aaaea-cai` |
| imageStore | `5tkpr-7d777-77775-aaaeq-cai` |
| jaxbLoan | `52jen-jl777-77775-aaafa-cai` |
| jdbcCredit | `55icz-et777-77775-aaafq-cai` |
| gsonLoan | `5iptu-f3777-77775-aaaga-cai` |
| jacksonLoan | `5pova-id777-77775-aaagq-cai` |
| java17Loan | `5gn64-6l777-77775-aaaha-cai` |
| pojoLoan | `5bmyi-tt777-77775-aaahq-cai` |
| springHello | `74rwa-a3777-77775-aaaia-cai` |
| xmlLoan | `73qqu-nd777-77775-aaaiq-cai` |

The calls cover greet and peek methods, identity getName, all seven loan apply methods and six getOffers queries, JDBC setCredit, image add/get byte round-trip, and Swift reversalRequest echo. These checks validate the sample canister interfaces and state behavior on PocketIC; they do not prove that every Java serializer encodes every field identically. The client integrations below cover the serializers exercised by those sample mains.

## Java client local integrations

These previously built 0.8.0 sample jars were run with a temporary classpath-first `application.properties` that pointed only to `http://127.0.0.1:18766/`, a temporary canister ID, and `ic.fetchRootKey=true`. No checked-in sample properties were edited.

| Sample | Local result |
| --- | --- |
| HelloWorld | `greet` returned “Hello, world!” |
| Gson | JSON fixture encoded, `apply` UPDATE completed, and offer decoded (`apr=3.14`) |
| Jackson | JSON fixture encoded, `apply` UPDATE completed, and offer decoded (`apr=3.14`) |
| JAXB | XML fixture decoded, `apply` UPDATE completed, and offer decoded (`apr=3.14`) |
| XML DOM | XML-to-Candid UPDATE completed; returned offer serialized back to XML |
| JDBC | Derby fixture produced rating 650 and `setCredit` UPDATE completed; database was created under `/tmp`. On its first run Derby logged the expected `DROP TABLE` error because the table did not yet exist, then created the table and completed successfully. |
| Image | Local PNG was added and read back; input and result were both 7,195 bytes |
| Swift | Both ISO 20022 echo UPDATEs completed against the local Swift canister; returned amounts were USD 5,000 and USD 12,345.67 |

These Java client runs used the earlier isolated DFX project at `127.0.0.1:18766`, whose DFX-bundled PocketIC was 13.0.0. The newer reusable workflow above separately verified all canister calls with PocketIC 16.1.0.

## Kafka 4.3.1 Camel local integration

The Apache Kafka 4.3.1 binary distribution [`kafka_2.13-4.3.1.tgz`](https://downloads.apache.org/kafka/4.3.1/kafka_2.13-4.3.1.tgz) was installed side-by-side with the existing standalone Kafka 3.3.1 tree. Its published SHA-512 was verified before extraction: `c7d7b2318cb51aa0c61d3246a51c349210073c5c9b754947ef965a439f2f939e8600f204e134a75ac31faf3829c9370960ef7c6a9886c8a1dbf0339a21f4c54c`. The older ZooKeeper-based installation and its configuration/data were left untouched. The test used the existing Java 21 runtime, which is supported by [Kafka 4.3.x](https://kafka.apache.org/43/operations/java-version/).

For the integration run, Kafka 4.3.1 used a fresh KRaft data directory and listeners bound only to `127.0.0.1:19092` (broker) and `127.0.0.1:19093` (controller). The task-scoped topic was `ic4j-codex-kafka-e2e-20261026`; the consumer group was `ic4j-codex-kafka-group-20261026`. Camel read a synthetic JSON file, produced one Kafka record, consumed it, called `apply` on the LoanProvider canister, and logged the returned offer (`applicationid=1`, provider `Loan Provider`). The consumer group reported current offset 1, log end offset 1, and lag 0. A local `getOffers` query returned the same offer.

The ICP CLI managed network reported `http://localhost:62261/`, verified as loopback, and used temporary canister `4caro-hl777-77775-aaaba-cai`. The sample configuration and routes were staged under a temporary directory with both endpoints overridden to loopback; the checked-in sample properties and route files were not changed for this run. Camel and Kafka were stopped, the temporary ICP network and its leftover PocketIC process were stopped, and the task-created temporary test directory was removed. The Kafka 4.3.1 installation remains available; the older 3.3.1 installation was not migrated.

## Per-sample matrix

| Sample | Build / local verification | Limits |
| --- | --- | --- |
| AndroidHelloWorld | Gradle APK assembly and host unit test passed earlier; canister deployed and greet UPDATE passed | No emulator/device run |
| Bitcoin | Gradle build passed | No Bitcoin mock canister source in the repo; sample points to a local Bitcoin node/service. No node was started |
| Camel | Maven test/package passed; isolated local end-to-end run sent a synthetic file event through Kafka 4.3.1, Camel, and the local LoanProvider; `getOffers` confirmed `applicationid=1`, consumer offset was 1 with lag 0 | The run used a temporary staged copy with loopback-only overrides; no checked-in public endpoint defaults were run |
| DocuTrack | Gradle build passed | No matching canister implementation is checked in; external DocuTrack behavior was not exercised |
| Gson | Maven package passed; Java client and local canister integration passed | Uses the checked-in sample JSON fixture only |
| HelloWorld | Gradle build and `HelloWorldProxyOfflineTest` passed; Java client local UPDATE passed | The metadata test inspects proxy annotations only; it does not contact a canister |
| HelloWorldAdvanced | Gradle build passed; local greet UPDATE and peek QUERY passed | Java main not run |
| Identity | Gradle build passed; local greet and getName behavior passed | Java main skipped because it reads checked-in Ed25519 and Secp256k1 PEM credential files |
| Image | Gradle build and local Java add/get integration passed | Uses the checked-in PNG fixture |
| InternetIdentity | Gradle build passed | Registration/device flows and identity/key files were not exercised |
| JAXB | Maven package and local Java/Candid integration passed | Uses the checked-in XML fixture |
| JDBC | Maven package and local JDBC-to-Candid integration passed | Database is disposable and was created under `/tmp` |
| Jackson | Maven package and local Java/Candid integration passed | Uses the checked-in JSON fixture |
| Java17 | Gradle build passed; local loan canister `apply` and `getOffers` passed | Java main generates an in-memory Ed25519 keypair, so it was not run. Runtime tested here was Java 21, not Java 17 |
| OrigynNFT | Gradle build passed | Requires the external Origyn NFT canister implementation; no matching local canister source was available |
| POJO | Gradle build passed; local loan canister `apply` and `getOffers` passed | Java main generates an in-memory Ed25519 keypair, so it was not run |
| Spring | Gradle build and mocked Spring test passed; local `greet` canister call passed | Spring application was not run against the local replica |
| SpringSample | Gradle build and mocked Spring test passed; local `greet` canister call passed | Spring application was not run against the local replica |
| Swift | Gradle build and both Java local ISO 20022 echo integrations passed | Uses checked-in XML fixtures; no external bank/network was contacted |
| WebSocket sample | Maven package passed; local canister greet UPDATE and peek QUERY passed | Existing nested `.dfx` state was not touched |
| XML | Maven package and local Java/Candid integration passed | Uses the checked-in XML fixture |

All 7 Maven modules and 11 regular Gradle JVM modules had successful package/build results in the prior verification. Both Spring tests passed after replacing remote service use with mocks, and Android host unit testing plus APK assembly passed. Gradle sample builds used Java source/target cohorts; only Java 21 runtime execution was available here, so bytecode targets do not certify execution on Java 8, 11, or 17.

## State preservation and prior remote incident

The reusable workflow did not touch pre-existing `.dfx` state. The earlier DFX test project and Java-client temporary configuration were under `/tmp`; its local DFX network was stopped after integration work. The final ICP CLI workflow network was stopped automatically by the script. A separate manually started PocketIC 16.1.0 check on `localhost:18776` outlived its CLI state: the CLI reported it stopped while the exact local PocketIC process (PID 43238, launched for `/tmp/ic4j-icp17-local`) still held the port. I stopped only that process and verified the endpoint was closed. The existing nested WebSocket sample’s user changes were preserved; this task added the Motoko `persistent actor` keyword needed by the current Motoko compiler.

An earlier turn made two unintended public UPDATE attempts before the safety restriction was reasserted. Both timed out; request IDs and remote effects remain unknown. No remote request was retried or polled during this continuation.
