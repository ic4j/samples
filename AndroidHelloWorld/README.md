# DfinityAndroidSample
# Android Native App connecting to the Internet Computer

Nothing fancy, just HelloWorld native Android application calling query and update on the Internet Computer. 
This application is using The Internet Computer Java Agent open source package

<a href="https://github.com/rdobrik/dfinity-agent">
https://github.com/rdobrik/dfinity-agent
</a>

The code is in MainActivity.kt file, demonstrates how to create HTTP Transport, set arguments, call both query and update operations.
Canister Motoko code is in main.mo file, to test it just copy and paste to Motoko Playground and deploy it. Then use canister id and url in strings.xml, modify canister and values.
I tested this app on Android 8.1, so it should be compatible with any newer versions, probably older as well.
This app is using OkHttp client in ReplicaTransport, so we can exclude Apache 5 HTTP client. (Apache client transport version should work too, but it requires some additional modifications in the gradle build file)

This is how you add Java Agent modules to your code (from Maven Central)

```
    implementation 'commons-codec:commons-codec:1.15'
    implementation('com.scaleton.dfinity:dfinity-agent:0.5.5') {
        exclude group: 'org.apache.httpcomponents.client5', module: 'httpclient5'
    }
```