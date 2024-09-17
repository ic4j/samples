# IC4JAndroidSample
# Android Native App connecting to the Internet Computer

Nothing fancy, just HelloWorld native Android application calling query and update on the Internet Computer. 
This application is using IC4J The Internet Computer Java Agent open source package

<a href="https://github.com/ic4j/ic4j-agent">
https://github.com/ic4j/ic4j-agent
</a>

The code is in MainActivity.kt file, demonstrates how to create HTTP Transport, set arguments, call both query and update operations.
Canister Motoko code is in main.mo file, to test it just copy and paste to Motoko Playground and deploy it. Then use canister id and url in strings.xml, modify canister and values.
I tested this app on Android 8.1, so it should be compatible with any newer versions, probably older as well.
This app is using OkHttp client in ReplicaTransport class, so it should be able to handle any type of HTTP requests.
Ic4J libraries are also using SLF4J for logging, so you can use any SLF4J implementation you like, I used slf4j-android in this example.

This is how you add Java Agent modules to your code (from Maven Central)

```
    implementation 'org.ic4j:ic4j-candid:0.7.4'
    implementation 'org.ic4j:ic4j-agent:0.7.4'
    implementation 'com.squareup.okhttp3:okhttp:4.12.0'
    implementation 'org.slf4j:slf4j-api:1.7.36'
    implementation 'org.slf4j:slf4j-android:1.7.36'  // or slf4j-simple if preferred
```