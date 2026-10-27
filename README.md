# IC4J Samples
Samples demonstrating different usage of IC4J Agent libraries.

## Offline local verification

Run `scripts/verify-local-canisters.sh` to compile the checked-in Motoko actors, deploy them to a disposable ICP CLI managed network bound to loopback, and run local UPDATE/QUERY smoke calls. The workflow keeps replica state under a new temporary directory, asks ICP CLI to stop that network, and removes the temporary directory only after confirming its loopback port is closed. It does not use sample `application.properties` or call `dfx start --clean`.

See [OFFLINE_VERIFICATION.md](OFFLINE_VERIFICATION.md) for tool versions, per-sample coverage, exact temporary canister IDs, and limits. DFINITY currently marks DFX as deprecated; the workflow uses the installed DFX compiler to build and ICP CLI to run the managed local network.

[IC4JHelloWorld](IC4JHelloWorld)
Java sample demonstrating call to Dfinity HelloWorld Dapp.

[IC4JHelloWorldAdvanced](IC4JHelloWorldAdvanced)
Advanced version of HelloWorld sample. Added Identity and QUERY call.

[IC4JIdentitySample](IC4JIdentitySample)
Java sample using different Identity mechanisms.

[IC4JInternetIdentitySample](IC4JInternetIdentitySample)
Java sample demonstrating how to use IC4J Internet Identity Java library.

[IC4JPojoSample](IC4JPojoSample)
Java sample demonstrating POJO object serialization and deserialization to/from Candid Record type.

[IC4JJacksonSample](IC4JJacksonSample)
Java sample demonstrating JSON Jackson object serialization and deserialization to/from Candid Record type.

[IC4JGsonSample](IC4JGsonSample)
Java sample demonstrating JSON GSON object serialization and deserialization to/from Candid Record type.

[IC4JXMLSample](IC4JXMLSample)
Java sample demonstrating XML DOM object serialization and deserialization to/from Candid Record type.

[IC4JJAXBSample](IC4JJAXBSample)
Java sample demonstrating XML JAXM object serialization and deserialization to/from Candid Record type.

[IC4JImageSample](IC4JJImageSample)
Java sample demonstrating byte array binary (png) object serialization and deserialzation to Candid Nat8 vector type.

[IC4JJDBCSample](IC4JJCBCSample)
Java sample demonstrating JDBC ResultSet object serialization to Candid Record type.

[IC4JJava17Sample](IC4JJava17Sample)
Java JDK 17 sample demonstrating use of ReplicaTransport based on Java 11 HTTP Client API.

[IC4JSwiftSample](IC4JSwiftSample)
Java sample demonstrates how to write the IC smart contracts with [Swift ISO20022](https://www.iso20022.org/) documents payloads.

[AndroidHelloWorld](AndroidHelloWorld)
Android Kotlin sample demonstrating call to Advanced HelloWorld Dapp.

[IC4JWSSample](IC4JWSSample)
Java Web App sample demonstrating REST and Websockets calls to Advanced HelloWorld Dapp using Oracle Helidon framework.

