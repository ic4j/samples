# IC4J Java sample demonstrating byte array binary (png) object serialization and deserialzation to Candid Nat8 vector type.

To install the canister Dapp, use Motoko code [main.mo](src/main.mo), copy/paste to [Motoko Playground](https://m7sm4-2iaaa-aaaab-qabra-cai.raw.ic0.app/) and deploy.

This application requires Java version 11.

Modify [application.properties](src/main/resources/application.properties) file to set canister location and id.

```
ic.location=https://icp-api.io/
ic.canister=ud6i4-iaaaa-aaaab-qadiq-cai
```

Run Gradle [build](build.gradle). Modify Java version in the build file if higher than 11.

```
gradle build
```

Run Java with fat jar

```
java -jar build/libs/ic4j-sample-image-0.7.0.jar
```
