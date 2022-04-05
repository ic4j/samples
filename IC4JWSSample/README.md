## IC4JWSSample
##Java WS connecting to the Internet Computer

This sample demonstrates how to use IC4J Java Agent to create Java Web Service using Oracle Helidon SE package. 
Java reactive code calls 2 Motoko canister methods
- peek (query method) returns value of variable name and uses HTTP GET to return JSON data payload.
- greet (call method) sets new a name value and returns new value back (Basically original Hello World sample from the IC, with persistence). Java Web Service receives HTTP POST JSON payload with new value, sends it to the IC. Then we use Websockets callback to return result of the canister method back to caller.

The sample has also simple HTML page with Javascript code to test Web Service and Websocket calls.

To deploy a new, modified version of Motoko code please follow Dfinity example installation instructions https://sdk.dfinity.org/docs/quickstart/local-quickstart.html, then replace generated Main.mo Motoko code with one provided in this package.

In application.yaml modify canister id value (and url, if needed).

Run 
```bash
mvn package
```

to build Java project and then run: 

```bash
java -jar target/ic4j-webservices-0.6.6.jar
```

to start Java Web Service (with Java 11)


To test Java Web Service run HTML page:

http://localhost:8082/web/index.html



