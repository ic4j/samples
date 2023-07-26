# IC4J Java sample demonstrating how to call Origyn NFT canister from Java application.

This sample is using the reference implementation of the [ORIGYN NFT](https://github.com/ORIGYN-SA/origyn_nft)  in motoko, the sales canister reference implementation, and the storage canister implementation that allows unlimited storage for NFT canisters. 

We used IC4J Codegen tool to generate [Java proxy and POJO classes](src/main/java/org/ic4j/origyn/nft) representing Origyn NFT canister intarface. 

This application requires Java version 11.

Modify [application.properties](src/main/resources/application.properties) file to set canister location and id.

```
ic.location=http://localhost:4943/
ic.canister=zdlco-vyaaa-aaaaa-aabva-cai
```

Run Gradle [build](build.gradle). Modify Java version in the build file if higher than 11.

```
gradle build
```

Run Java with fat jar

```
java -jar build/libs/ic4j-sample-origyn-nft-0.6.19.jar
```
