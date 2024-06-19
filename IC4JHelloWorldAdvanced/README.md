# IC4J Java Agent sample calling Advanced Dfinity HelloWorld Canister.

To install Dapp canister, use Motoko code [main.mo](src/main.mo), copy/paste to [Motoko Playground](https://m7sm4-2iaaa-aaaab-qabra-cai.raw.ic0.app/) and deploy.

This application requires Java version 1.8.

Modify [application.properties](src/main/resources/application.properties) file to set canister location and id.

```
ic.location=https://icp-api.io/
ic.canister=75i2c-tiaaa-aaaab-qacxa-cai
```

Run Gradle [build](build.gradle). Modify Java version in the build file if higher than 1.8.

```
gradle build
```

Run Java with fat jar

```
java -jar build/libs/ic4j-sample-helloworld-advanced-0.7.0.jar
```
