package org.ic4j.samples.internetidentity;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Base64;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

import javax.imageio.ImageIO;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.ic4j.agent.Agent;
import org.ic4j.agent.AgentBuilder;
import org.ic4j.agent.ReplicaTransport;
import org.ic4j.agent.http.ReplicaApacheHttpTransport;
import org.ic4j.agent.identity.BasicIdentity;
import org.ic4j.agent.identity.Identity;
import org.ic4j.internetidentity.AddTentativeDeviceResponse;
import org.ic4j.internetidentity.Challenge;
import org.ic4j.internetidentity.ChallengeResult;
import org.ic4j.internetidentity.DeviceData;
import org.ic4j.internetidentity.DeviceProtection;
import org.ic4j.internetidentity.DeviceWithUsage;
import org.ic4j.internetidentity.GetDelegationResponse;
import org.ic4j.internetidentity.IdentityAnchorInfo;
import org.ic4j.internetidentity.InternetIdentityService;
import org.ic4j.internetidentity.InternetIdentityStats;
import org.ic4j.internetidentity.KeyType;
import org.ic4j.internetidentity.PrepareDelegationResponse;
import org.ic4j.internetidentity.Purpose;
import org.ic4j.internetidentity.RegisterResponse;
import org.ic4j.internetidentity.VerifyTentativeDeviceResponse;
import org.ic4j.types.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "subcommands")
class Main implements Callable<Integer> {
	static String PROPERTIES_FILE_NAME = "application.properties";

	static Logger LOG = LoggerFactory.getLogger(Main.class);

	@Option(names = { "--pemfile" }, defaultValue = "identity.pem")
	private String pemFile = "identity.pem";
	
	@Option(names = { "--devicepemfile" })
	private String devicePemFile;	

	@Option(names = { "--captchafile" }, defaultValue = "challenge.png")
	private String captchaFile = "challenge.png";
	
	@Option(names = { "--device" }, defaultValue = "Device 1")
	private String deviceAlias = "Device 1";	

	@Option(names = { "--env" })
	private String envFile;
	
	@Option(names = { "--challengekey" })
	private String challengeKey;	
	
	@Option(names = { "--captcha" })
	private String captcha;		
	
	@Option(names = { "--userid" })
	private Long userId;	
	
	byte[] sessionKey;

	public static void main(String[] args) {
		int rc = new CommandLine(new Main()).execute(args);
		System.exit(rc);
	}

	@Command(name = "test")
	public void test() {
		try {
			Security.addProvider(new BouncyCastleProvider());

			InputStream propInputStream = new FileInputStream(this.envFile);
			Properties env = new Properties();
			env.load(propInputStream);

			String iiLocation = env.getProperty("ii.location");

			ReplicaTransport transport = ReplicaApacheHttpTransport.create(iiLocation);

			KeyPair keyPair = InternetIdentityService.generateSessionKey();
			BasicIdentity identity = BasicIdentity.fromKeyPair(keyPair);

			InternetIdentityService.savePrivateKey(keyPair.getPrivate(), "identity.pem");

			Agent agent = new AgentBuilder().transport(transport).identity(identity).build();
			
			agent.fetchRootKey();

			InternetIdentityService internetIdentityService = InternetIdentityService.create(agent, env);

			sessionKey = identity.getPublicKey();

			CompletableFuture<Challenge> challengeResponse = internetIdentityService.createChallenge();

			Challenge challenge = challengeResponse.get();

			LOG.info(challenge.pngBase64);
			LOG.info(challenge.challengeKey);

			// convert byte[] to a BufferedImage
			BufferedImage captchaImage = internetIdentityService.getCaptchaImage(challenge);

			ChallengeResult challengeResult = new ChallengeResult();

			challengeResult.challengeKey = challenge.challengeKey;
			challengeResult.chars = "a";

			DeviceData device = new DeviceData();

			device.alias = "Device 1";
			device.pubkey = sessionKey;

			Purpose purpose = Purpose.authentication;

			device.purpose = purpose;

			KeyType keyType = KeyType.platform;
			device.keyType = keyType;

			CompletableFuture<RegisterResponse> registerResponse = internetIdentityService.register(device,
					challengeResult);

			RegisterResponse register = registerResponse.get();
			LOG.info(register.name());
			LOG.info(register.registeredValue.userNumber.toString());

			Long userNumber = register.registeredValue.userNumber;

			String frontendHostname = "http://0.0.0.0:8000/?canisterId=rdmx6-jaaaa-aaaaa-aaadq-cai&id=renrk-eyaaa-aaaaa-aaada-cai";

			CompletableFuture<PrepareDelegationResponse> response = internetIdentityService
					.prepareDelegation(userNumber, frontendHostname, sessionKey, Optional.empty());

			PrepareDelegationResponse prepareDelegationResponse = response.get();

			LOG.info(Base64.getEncoder().encodeToString(prepareDelegationResponse.userKey));

			GetDelegationResponse getDelegationResponse = internetIdentityService.getDelegation(userNumber,
					frontendHostname, sessionKey, prepareDelegationResponse.timestamp);

			LOG.info(Base64.getEncoder().encodeToString(getDelegationResponse.signedDelegation.signature));

			Principal principal = internetIdentityService.getPrincipal(userNumber, frontendHostname);

			LOG.info(principal.toString());

			keyPair = InternetIdentityService.generateSessionKey();

			device.alias = "Device 2";
			device.pubkey = keyPair.getPublic().getEncoded();

			Long enterDeviceRegistrationModeResponse = internetIdentityService.enterDeviceRegistrationMode(userNumber)
					.get();

			AddTentativeDeviceResponse addTentativeDeviceResponse = internetIdentityService
					.addTentativeDevice(userNumber, device).get();

			LOG.info(addTentativeDeviceResponse.name());

			LOG.info(addTentativeDeviceResponse.addedTentatively.verificationCode);

			VerifyTentativeDeviceResponse verifyTentativeDeviceResponse = internetIdentityService
					.verifyTentativeDevice(userNumber, addTentativeDeviceResponse.addedTentatively.verificationCode)
					.get();

			LOG.info(verifyTentativeDeviceResponse.name());

			internetIdentityService.exitDeviceRegistrationMode(userNumber);

			internetIdentityService.add(userNumber, device);

			DeviceData[] deviceData = internetIdentityService.lookup(userNumber);

			for (int i = 0; i < deviceData.length; i++)
				LOG.info(deviceData[i].alias);

			IdentityAnchorInfo identityAnchorInfoResponse = internetIdentityService.getAnchorInfo(userNumber).get();

			DeviceWithUsage[]deviceDataWithUsage  = identityAnchorInfoResponse.devices;

			for (int i = 0; i < deviceDataWithUsage.length; i++)
				LOG.info(deviceDataWithUsage[i].alias);

			internetIdentityService.remove(userNumber, device.pubkey);

			deviceData = internetIdentityService.lookup(userNumber);

			for (int i = 0; i < deviceData.length; i++)
				LOG.info(deviceData[i].alias);

			InternetIdentityStats stats = internetIdentityService.stats();
			LOG.info(stats.usersRegistered.toString());

		} catch (Throwable e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}

	@Command(name = "identity")
	public void CreateIdentity() {
		Security.addProvider(new BouncyCastleProvider());

		KeyPair keyPair;
		try {
			keyPair = KeyPairGenerator.getInstance("Ed25519",BouncyCastleProvider.PROVIDER_NAME).generateKeyPair();

			Identity identity = BasicIdentity.fromKeyPair(keyPair);

			InternetIdentityService.savePrivateKey(keyPair.getPrivate(), this.pemFile);

			LOG.info("Created identity PEM file " + this.pemFile);

		} catch (NoSuchAlgorithmException | IOException | NoSuchProviderException e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}
	
	@Command(name = "challenge")
	public void createChallenge() {
		try {
			InternetIdentityService internetIdentityService = this.createInternetIdentityService();
			CompletableFuture<Challenge> challengeResponse = internetIdentityService.createChallenge();

			Challenge challenge = challengeResponse.get();

			LOG.info("Get Captcha from PNG image " + this.captchaFile);
			LOG.info("Register using challenge key :" + challenge.challengeKey);

			// convert byte[] back to a BufferedImage
			BufferedImage captchaImage = internetIdentityService.getCaptchaImage(challenge);

			// save it
			ImageIO.write(captchaImage, "png", Paths.get(this.captchaFile).toFile());			

		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}
	
	
	@Command(name = "register")
	public void register() {

		try {
			InternetIdentityService internetIdentityService = this.createInternetIdentityService();
			ChallengeResult challengeResult = new ChallengeResult();

			challengeResult.challengeKey = this.challengeKey;
			challengeResult.chars = this.captcha;

			DeviceData device = new DeviceData();

			device.alias = this.deviceAlias;
			device.pubkey = sessionKey;

			Purpose purpose = Purpose.authentication;

			device.purpose = purpose;

			KeyType keyType = KeyType.platform;
			device.keyType = keyType;
			
			device.protection = DeviceProtection.isunprotected;

			device.credentialId = Optional.empty();

			CompletableFuture<RegisterResponse> registerResponse = internetIdentityService.register(device,
					challengeResult);

			RegisterResponse register = registerResponse.get();
			LOG.info("Registration status:" + register.name());
			if(register == RegisterResponse.registered)
				LOG.info("User Id:" + register.registeredValue.userNumber.toString());		

		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}
	
	@Command(name = "adddevice")
	public void addDevice() {

		try {
			InternetIdentityService internetIdentityService = this.createInternetIdentityService();

			KeyPair keyPair = KeyPairGenerator.getInstance("Ed25519",BouncyCastleProvider.PROVIDER_NAME).generateKeyPair();
			
			if(this.devicePemFile == null)				
				this.devicePemFile = this.deviceAlias + ".pem";

			InternetIdentityService.savePrivateKey(keyPair.getPrivate(), this.devicePemFile);

			LOG.info("Created device " + this.deviceAlias + " identity PEM file " + this.devicePemFile);

			DeviceData device = new DeviceData();

			device.alias = this.deviceAlias;
			device.pubkey = keyPair.getPublic().getEncoded();
			device.protection = DeviceProtection.isunprotected;
			
			device.credentialId = Optional.empty();

			Purpose purpose = Purpose.authentication;

			device.purpose = purpose;

			KeyType keyType = KeyType.platform;
			device.keyType = keyType;

			internetIdentityService.add(this.userId, device);	

		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}	
	
	@Command(name = "removedevice")
	public void removeDevice() {

		try {
			InternetIdentityService internetIdentityService = this.createInternetIdentityService();

			BasicIdentity identity = BasicIdentity.fromPEMFile(Paths.get(this.devicePemFile));	

			internetIdentityService.remove(this.userId, identity.derEncodedPublickey);	

		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}	
	
	@Command(name = "lookup")
	public void lookup() {

		try {
			InternetIdentityService internetIdentityService = this.createInternetIdentityService();

			IdentityAnchorInfo identityAnchorInfoResponse = internetIdentityService.getAnchorInfo(this.userId).get();

			DeviceWithUsage[] deviceDataWithUsage = identityAnchorInfoResponse.devices;

			LOG.info("User Id:" + this.userId);	
			
			for (int i = 0; i < deviceDataWithUsage.length; i++)
				LOG.info(deviceDataWithUsage[i].alias);

		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}	

	private InternetIdentityService createInternetIdentityService()
			throws IOException, URISyntaxException, NoSuchAlgorithmException {

		Security.addProvider(new BouncyCastleProvider());
		
		BasicIdentity identity = BasicIdentity.fromPEMFile(Paths.get(this.pemFile));
		
		this.sessionKey = identity.derEncodedPublickey;
		
		Properties env;
		
		if(this.envFile != null)
		{
			InputStream propInputStream = new FileInputStream(this.envFile);
			env = new Properties();
			env.load(propInputStream);
		}
		else
			env = InternetIdentityService.getIIProperties();

		String iiLocation = env.getProperty("ii.location");
		
		ReplicaTransport transport = ReplicaApacheHttpTransport.create(iiLocation);

		Agent agent = new AgentBuilder().transport(transport).identity(identity).build();
		
		agent.fetchRootKey();
		
		agent.setVerify(false);

		return InternetIdentityService.create(agent, env);
	}

	@Override
	public Integer call() throws Exception {
		System.out.println("Subcommand needed: 'identity', 'challenge', 'register', 'lookup', 'adddevice', or 'removedevice' ");
		return 0;
	}

}
