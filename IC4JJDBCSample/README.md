# IC4J Java sample demonstrating JDBC ResultSet object serialization  to Candid Record type.

To install the canister Dapp, use Motoko code [main.mo](src/main.mo), copy/paste to [Motoko Playground](https://m7sm4-2iaaa-aaaab-qabra-cai.raw.ic0.app/) and deploy.

This application requires Java version 11.

Modify [application.properties](src/main/resources/application.properties) file to set canister location and id.

```
ic.location=https://m7sm4-2iaaa-aaaab-qabra-cai.ic0.app/
ic.canister=4n3qe-piaaa-aaaab-qac7a-cai
```

Run Maven [build](pom.xml). Modify Java version in the build file if higher than 11.

```
mvn package
```

Run Java with fat jar

```
java -jar target/ic4j-sample-jdbc-0.6.19.jar
```
