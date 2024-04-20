package org.ic4j.samples.docutrack;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

import org.apache.commons.lang3.ArrayUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.ic4j.agent.Agent;
import org.ic4j.agent.AgentBuilder;
import org.ic4j.agent.ProxyBuilder;
import org.ic4j.agent.ReplicaTransport;
import org.ic4j.agent.http.ReplicaJavaHttpTransport;
import org.ic4j.agent.identity.BasicIdentity;
import org.ic4j.docutrack.DocuTrackProxy;
import org.ic4j.docutrack.Download_file_response;
import org.ic4j.docutrack.File_metadata;
import org.ic4j.docutrack.Get_users_response;
import org.ic4j.docutrack.Upload_file_atomic_request;
import org.ic4j.docutrack.Who_am_i_response;
import org.ic4j.internetidentity.InternetIdentityService;
import org.ic4j.types.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "subcommands")
public class Main {
	static String PROPERTIES_FILE_NAME = "application.properties";

	static String icLocation;
	static String icCanister;

	@Option(names = { "--pemfile" }, defaultValue = "user.pem")
	private String pemFile = "user.pem";

	@Option(names = { "--username" })
	private String userName = "JavaUser";

	static Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		try {
			Security.addProvider(new BouncyCastleProvider());

			InputStream propInputStream = Main.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);

			Properties env = new Properties();
			env.load(propInputStream);

			icLocation = env.getProperty("ic.location");
			icCanister = env.getProperty("ic.canister");
			int rc = new CommandLine(new Main()).execute(args);
			System.exit(rc);

		} catch (Throwable e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}

	@Command(name = "run")
	public void run() {
		try {
			BasicIdentity identity = BasicIdentity.fromPEMFile(Paths.get(this.pemFile));

			ReplicaTransport transport = ReplicaJavaHttpTransport.create(icLocation);
			Agent agent = new AgentBuilder().transport(transport).identity(identity).build();

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

		} catch (Throwable e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}

	@Command(name = "init")
	public void Initialize() {
		Security.addProvider(new BouncyCastleProvider());

		KeyPair keyPair;
		try {
			keyPair = InternetIdentityService.generateSessionKey();
			BasicIdentity identity = BasicIdentity.fromKeyPair(keyPair);

			InternetIdentityService.savePrivateKey(keyPair.getPrivate(), this.pemFile);

			LOG.info("Created user PEM file " + this.pemFile);

			ReplicaTransport transport = ReplicaJavaHttpTransport.create(icLocation);

			Agent agent = new AgentBuilder().transport(transport).identity(identity).build();

			DocuTrackProxy docuTrackProxy = ProxyBuilder.create(agent, Principal.fromString(icCanister))
					.getProxy(DocuTrackProxy.class);

			docuTrackProxy.set_user(this.userName, ArrayUtils.toObject(identity.derEncodedPublickey));

			LOG.info("Created DocuTrack user " + this.userName);

		} catch (NoSuchAlgorithmException | IOException | URISyntaxException e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}

}
