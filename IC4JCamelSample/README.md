# IC4J Java sample demonstrating Apache Camel route from Apache Kafka topic to Internet Computer Canister.

Pre-requisites: You need an available Apache Kafka server. To learn how to install it, you can check this article: <a href="http://www.masterspringboot.com/apache-kafka/getting-started-with-apache-kafka/">
Getting started with Apache Kafka
</a> 

start the ZooKeeper server. Kafka provides a simple ZooKeeper configuration file to launch a single ZooKeeper instance. To install the ZooKeeper instance, use the following command.

```
bin/zookeeper-server-start.sh config/zookeeper.properties
```

NOTE: If you are using localhost as bind address, we recommend setting the advertised.listeners property as follows in config/server.properties file.

```
advertised.listeners=PLAINTEXT://localhost:9092
```

Start the Kafka broker with the following command.

```
bin/kafka-server-start.sh config/server.properties
```
 

Create a Topic that will be using in your application.

```
bin/kafka-topics.sh --bootstrap-server=localhost:9092 --create --topic icTopic --partitions 1 --replication-factor 1 --if-not-exists
```

To install the canister Dapp, use Motoko code [main.mo](src/main.mo), copy/paste to [Motoko Playground](https://m7sm4-2iaaa-aaaab-qabra-cai.raw.ic0.app/) and deploy.

Modify [application.properties](src/main/resources/application.properties) file to set canister location and id.

```
ic.location=https://m7sm4-2iaaa-aaaab-qabra-cai.ic0.app/
ic.canister=4w6mb-vqaaa-aaaab-qac5q-cai
```

This application requires Java version 11.

By default this sample is using two Apache Camel routes defined in [ic-route.yaml](src/main/resources/routes/ic-route.yaml) file. The first route  reads JSON file and drops it into Kafka topic icTopic. The second route reads messages from Kafka topic icTopic and sends them to the internet Computer canister.

```
apiVersion: camel.apache.org/v1
kind: Integration
metadata:
  name: CamelICdemo
spec:
  flows:
    - route:
        from:
          uri: file:src/data?noop=true
          steps:
            - setHeader:
                name: kafka.KEY
                expression:
                  constant:
                    expression: Camel
            - to:
                uri: kafka:icTopic?brokers=localhost:9092
        id: kafka  
    - route:
        from:
          uri: kafka:icTopic?brokers=localhost:9092
          steps:
            - log:
                message: ${body}
            - unmarshal:
                json:
                  library: jackson
                  unmarshalType: org.ic4j.samples.camel.LoanApplication
            - to:
                uri: >-
                  ic:update?url={{ic.location}}&method=apply&canisterId={{ic.canister}}&outClass=org.ic4j.samples.camel.LoanOffer
            - marshal:
                json:
                  library: jackson
                  unmarshalType: org.ic4j.samples.camel.LoanOffer
            - log:
                message: ${body}
        id: ic
```

NOTE: This sample has also an option to run same routes, but definded using Java Route Builder [ICRouteBuilder](src/main/org/ic4j/samples/camel/ICRouteBuilder.java). To run it, just uncomment line in [CamelMain](src/main/org/ic4j/samples/camel/CamelMain.java) file and comment out property camel.main.routes-include-pattern in [application.properties](src/main/resources/application.properties) file.


Run Maven [build](pom.xml). Modify Java version in the build file if higher than 11.

```
mvn package
```

Run Java with fat jar

```
java -jar target/ic4j-sample-camel-0.6.17.jar
```
