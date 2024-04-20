# IC4J Java sample demonstrating how to call Dfinity DocuTrack service from Java application.

This sample is using the reference implementation of the [DocuTrack](https://github.com/dfinity/ic-docutrack). DocuTrack is a proof-of-concept dapp for sharing and managing documents.

We used IC4J Codegen tool to generate [Java proxy and POJO classes](src/main/java/org/ic4j/docutrack) representing DocuTrack canister interface. 

This application requires Java version 11.


Run Gradle [build](build.gradle). Modify Java version in the build file if higher than 11.

```
gradle build
```

Run Java with fat jar to create a new DocuTrack user. Set your custom username. This function will create identity file user.pem. 

```
java -jar build/libs/ic4j-sample-docutrack-0.6.19.jar --username "JavaUser" init
```

Then run Java with fat jar to call different DocuTrack functions. Use username created before.

```
java -jar build/libs/ic4j-sample-docutrack-0.6.19.jar --username "JavaUser" run
```


```
DocuTrackProxy docuTrackProxy = ProxyBuilder.create(agent, Principal.fromString(icCanister))
					.getProxy(DocuTrackProxy.class);

Who_am_i_response response = docuTrackProxy.who_am_i();

LOG.info(response.fieldknown_userValue.username);

Get_users_response users = docuTrackProxy.get_users();

LOG.info("Users " + Integer.toString(users.usersValue.length));

File_metadata[] files = docuTrackProxy.get_requests();

LOG.info("Files " + Integer.toString(files.length));

files = docuTrackProxy.get_shared_files();

LOG.info("Shared Files " + Integer.toString(files.length));

Path path = Paths.get("dfinity.png");

Upload_file_atomic_request uploadFileRequest = new Upload_file_atomic_request();

uploadFileRequest.name = path.getFileName().toString();
uploadFileRequest.content = ArrayUtils.toObject(Files.readAllBytes(path));
uploadFileRequest.fieldfile_type = Files.probeContentType(path);
uploadFileRequest.fieldnum_chunks = 1l;
uploadFileRequest.fieldowner_key = ArrayUtils.toObject(identity.derEncodedPublickey);

CompletableFuture<Long> uploadFileResponse = docuTrackProxy.upload_file_atomic(uploadFileRequest);

files = docuTrackProxy.get_requests();

LOG.info("Files " + Integer.toString(files.length));

for (File_metadata file : files) {
	Download_file_response downloadFile = docuTrackProxy.download_file(file.fieldfile_id, 0l);
	LOG.info("File " + file.fieldfile_name);
}

files = docuTrackProxy.get_shared_files();

LOG.info("Shared Files " + Integer.toString(files.length));
```
