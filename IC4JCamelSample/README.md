# Kafka to LoanProvider with Apache Camel

This sample uses Java 21 and IC4J 0.8.5. Its [Camel routes](src/resources/routes/kafka-ic-route.camel.yaml)
read JSON files from `src/data`, publish them to Kafka, and call `LoanProvider.apply`
as the anonymous identity using the Java HTTP transport. Use synthetic data:
the demo logs the input and the resulting offer.

## Local smoke test

The [Samples workflow](../.github/workflows/samples.yml) runs the packaged sample
with Kafka 4.3.1 in KRaft mode (no ZooKeeper) and an isolated PocketIC instance.
It builds [LoanProvider](src/main.mo), starts with no offers, drops in one
synthetic file, and checks both the committed Kafka offset (1 with zero lag)
and the one offer returned by `getOffers`. All service connections go to
loopback. The optional IMAP route is not loaded.

To run the same test locally, install Java 21, Maven, Python 3, Kafka 4.3.1,
DFX 0.32.0, and ICP CLI 1.7.0. The IC4J 0.8.5 dependencies must already be in
your Maven repository; the workflow instead builds them from pinned source.

```sh
mvn -f IC4JCamelSample/pom.xml clean verify
KAFKA_HOME=/path/to/kafka_2.13-4.3.1 \
  KAFKA_REPORTS=/path/to/test-reports \
  bash scripts/verify-local-canisters.sh kafka
```

Run these commands from the repository root. Set `ICP_CLI_NETWORK_LAUNCHER_PATH`
to the pinned PocketIC launcher if ICP CLI does not already have it configured.
The report directory is optional and keeps the broker log, sample log, observed
Kafka offsets, and canister response for inspection.

## Running against your own local services

Create `icTopic` with one partition on your Kafka broker. Deploy [LoanProvider](src/main.mo)
to your local replica and configure [application.properties](src/resources/application.properties)
before packaging. Set `ic.location` to your local replica URL, `ic.canister` to its
LoanProvider ID, and `ic.fetchRootKey=true` only for a trusted local replica.
Use the `kafka.*` settings to configure the broker, topic, and consumer group.

```sh
cd IC4JCamelSample
mvn clean package
java -jar target/ic4j-sample-camel-0.8.0.jar
```

Leave the `target/libs` directory next to the jar. The optional
[IMAP route](src/resources/routes/email-ic-route.yaml) and
[Java RouteBuilder example](src/main/org/ic4j/samples/camel/ICRouteBuilder.java)
are separate examples, not covered by this test.
