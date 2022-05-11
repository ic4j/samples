# IC4J Java Agent sample calling Dfinity Bitcoin Canister.

Install local Bitcoin canister, using Dfinity Bitcoin Preview https://github.com/dfinity/bitcoin-developer-preview

This application requires Java version 1.8.

Modify [application.properties](src/main/resources/application.properties) file to set canister location and id.

```
ic.location=https://localhost:8000/
ic.canister=yaku6-4iaaa-aaaab-qacfa-cai
btc.address=bcrt1q39q34vdaawtkzng3j5wycjwxxdgtqfz2fhlqxp
```

Run Gradle [build](build.gradle). Modify Java version in the build file if higher than 1.8.

```
gradle build
```

Run Java with fat jar to return Bitcoin balance

```
java -jar build/libs/ic4j-sample-bitcoin-0.6.8.jar
```
