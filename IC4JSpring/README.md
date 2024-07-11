# Java Spring application sample calling Dfinity HelloWorld Canister.

To install Dapp canister, use Motoko code [main.mo](src/main.mo) either on local [Dfinity SDK](https://smartcontracts.org/docs/quickstart/quickstart-intro.html) or remote [Motoko Playground](https://m7sm4-2iaaa-aaaab-qabra-cai.raw.ic0.app/).

This application requires Java version 17.

Modify [HelloWorldProxy.java](src/main/java/org/ic4j/samples/spring/helloworld/HelloWorldProxy.java) file to set canister location and canister id.

```
@Agent(identity = @Identity(type = IdentityType.ANONYMOUS), transport = @Transport(url = "https://icp-api.io/"))
@Canister("3z2ve-waaaa-aaaab-qacmq-cai")
public interface HelloWorldProxy {
```

Run Gradle [build](build.gradle). 

```
./gradlew bootRun
```

Run curl to execute HTTP POST request

```
curl -X POST -H "Content-Type: text/plain" -d "Motoko" http://localhost:8080/greet
```
