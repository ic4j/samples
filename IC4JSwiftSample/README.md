# IC4J Java Agent sample calling the IC canister with Swift ISO20022 documents.

This application requires Java version 1.8.

This sample demonstrates how to write the IC smart contracts with [Swift ISO20022](https://www.iso20022.org/) documents payloads. 
Motoko types representing Swift documents are generated from ISO20022 XML definition. The Java client then uses JAXB serializer and deserializer to convert [Prowide JAXB XML Objects](https://github.com/prowide/prowide-iso20022) to Candid types and back.

To install Dapp canister,use [Motoko Playground](https://m7sm4-2iaaa-aaaab-qabra-cai.raw.ic0.app/) or local [Dfinity SDK](https://smartcontracts.org/docs/quickstart/quickstart-intro.html).

### Deploy to Motoko Playground

Deploy canister using WASM [swift_backend.wasm](/src/motoko/swift_backend.wasm) and DID IDL [swift_backend.did](/src/motoko/swift_backend.did) files to [Motoko Playground](https://m7sm4-2iaaa-aaaab-qabra-cai.raw.ic0.app/).


Modify [application.properties](src/main/resources/application.properties) file to set canister id.

```
ic.location=https://m7sm4-2iaaa-aaaab-qabra-cai.ic0.app/
ic.canister=su63m-yyaaa-aaaaa-aaala-cai
```

### Deploy locally 

Canister source code is in [motoko directory](/src/motoko). To install the sample canister run dfx deploy command in this directory.

```
dfx deploy
```

Modify [application.properties](src/main/resources/application.properties) file to set canister location and id.

```
ic.location=http://127.0.0.1:8000/
ic.canister=su63m-yyaaa-aaaaa-aaala-cai
```

Run Gradle [build](build.gradle). Modify Java version in the build file if higher than 1.8.

```
gradle build
```

Run Java with fat jar

```
java -jar build/libs/ic4j-sample-swift-0.6.19.jar 
```
