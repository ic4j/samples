# IC4J Java Agent sample calling Dfinity HelloWorld Canister.

To install Dapp canister, use either local [Dfinity SDK](https://smartcontracts.org/docs/quickstart/quickstart-intro.html) or remote [Motoko Playground](https://m7sm4-2iaaa-aaaab-qabra-cai.raw.ic0.app/).

This application requires Java version 1.8.

Modify [application.properties](src/main/resources/application.properties) file to set canister location and id.

```
ic.location=https://icp-api.io/
ic.canister=7pon3-7yaaa-aaaab-qacua-cai
```

Run Gradle [build](build.gradle). Modify Java version in the build file if higher than 1.8.

```
gradle build
```

Run Java with fat jar

```
java -jar build/libs/ic4j-sample-helloworld-0.6.19.jar
```
