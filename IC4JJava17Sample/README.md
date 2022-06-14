# IC4J Java JDK 17 sample demonstrating use of ReplicaTransport based on Java 11 HTTP Client API.

To install the canister Dapp, use Motoko code [main.mo](src/main.mo), copy/paste to [Motoko Playground](https://m7sm4-2iaaa-aaaab-qabra-cai.raw.ic0.app/) and deploy.

This application requires Java version 17.

Modify [application.properties](src/main/resources/application.properties) file to set canister location and id.

```
ic.location=https://m7sm4-2iaaa-aaaab-qabra-cai.raw.ic0.app/
ic.canister=4w6mb-vqaaa-aaaab-qac5q-cai
```

Run Gradle [build](build.gradle). Modify Java version in the build file if higher than 17.

```
gradle build
```

Run Java with fat jar

```
java -jar build/libs/ic4j-sample-java17-0.6.13.jar
```
