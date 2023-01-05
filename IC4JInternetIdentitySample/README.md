# IC4J Java Agent sample calling Dfinity Internet Identity.

This is a sample use case demonstrating how to use IC4J Internet Identity Java library.

[https://github.com/ic4j/ic4j-internetidentity](https://github.com/ic4j/ic4j-internetidentity)

The library is a Java implementation of Dfinity Internet Identity specification.

[https://github.com/dfinity/internet-identity/blob/main/docs/internet-identity-spec.adoc#the-internet-identity-specification](https://github.com/dfinity/internet-identity/blob/main/docs/internet-identity-spec.adoc#the-internet-identity-specification)

To test locally install local Internet Identity canister [https://github.com/dfinity/internet-identity/tree/main/demos/using-dev-build](https://github.com/dfinity/internet-identity/tree/main/demos/using-dev-build)

This application requires Java version 1.8.

To test locally, modify [application.properties](application.properties) file to set internet identity canister location and id.

```
ii.location=http://localhost:4943/
ii.canister=rwlgt-iiaaa-aaaaa-aaaaa-cai
```

Run Gradle [build](build.gradle). Modify Java version in the build file if higher than 1.8.

```
gradle build
```

Run Java with fat jar to call Internet Identity methods. To run locally, set env option. Otherwise it will execute calls on the network Intertnet Identity service.

To create Identity PEM file identity.pem.

```
java -jar build/libs/ic4j-sample-internetidentity-0.6.18.jar identity
```

To generate Captcha challenge. This will create png Captcha file challenge.png.

```
java -jar build/libs/ic4j-sample-internetidentity-0.6.18.jar --env "application.properties" --pemfile "identity.pem" challenge
[main] INFO org.ic4j.samples.internetidentity.Main - Get Captcha from PNG image challenge.png
[main] INFO org.ic4j.samples.internetidentity.Main - Register using challenge key :owesuvvgqs
```

Use Captcha chars and challenge key to register a new user.

```
java -jar build/libs/ic4j-sample-internetidentity-0.6.18.jar --env "application.properties" --pemfile "identity.pem" --challengekey "quimbxabjx" --captcha "a" --device "Device2" register
[main] INFO org.ic4j.samples.internetidentity.Main - Registration status:registered
[main] INFO org.ic4j.samples.internetidentity.Main - User Id:10002
```

Use user id to add or remove a device.

```
java -jar build/libs/ic4j-sample-internetidentity-0.6.18.jar --userid "10002" --env "application.properties" --device "Device3" adddevice
[main] INFO org.ic4j.samples.internetidentity.Main - Created device Device3 identity PEM file Device3.pem
```

```
java -jar build/libs/ic4j-sample-internetidentity-0.6.18.jar --userid "10002" --env "application.properties" --devicepemfile "Device3.pem" removedevice
```

Lookup all user devices.

```
java -jar build/libs/ic4j-sample-internetidentity-0.6.18.jar --userid "10002" --env "application.properties" lookup
[main] INFO org.ic4j.samples.internetidentity.Main - User Id:10002
[main] INFO org.ic4j.samples.internetidentity.Main - Device:Device2
```

