package org.ic4j.samples.identity;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Security;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.ic4j.agent.Agent;
import org.ic4j.agent.AgentBuilder;
import org.ic4j.agent.ProxyBuilder;
import org.ic4j.agent.ReplicaTransport;
import org.ic4j.agent.http.ReplicaApacheHttpTransport;
import org.ic4j.agent.identity.AnonymousIdentity;
import org.ic4j.agent.identity.BasicIdentity;
import org.ic4j.agent.identity.Identity;
import org.ic4j.agent.identity.Secp256k1Identity;
import org.ic4j.types.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	static String PROPERTIES_FILE_NAME = "application.properties";
	
	protected static String ED25519_IDENTITY_FILE = "Ed25519_identity.pem";	
	protected static String SECP256K1_IDENTITY_FILE = "Secp256k1_identity.pem";	

	static Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		try {
			Security.addProvider(new BouncyCastleProvider());
			
			InputStream propInputStream = Main.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);

			Properties env = new Properties();
			env.load(propInputStream);

			String icLocation = env.getProperty("ic.location");
			String icCanister = env.getProperty("ic.canister");

			// Use Inonymous Identity
			Identity identity = new AnonymousIdentity();

			ReplicaTransport transport = ReplicaApacheHttpTransport.create(icLocation);
			Agent agent = new AgentBuilder().transport(transport).identity(identity).build();
			
			HelloWorldProxy helloWorldProxy = ProxyBuilder.create(agent, Principal.fromString(icCanister))
					.getProxy(HelloWorldProxy.class);

			String value = "anonymous";
			
			CompletableFuture<String> proxyResponse = helloWorldProxy.greet(value);
			
			String output = proxyResponse.get();
			LOG.info(output);

			// Use Basic Identity (ED25519)
			
			InputStream sourceInputStream = Main.class.getClassLoader().getResourceAsStream(ED25519_IDENTITY_FILE);

			identity = BasicIdentity.fromPEMFile(new InputStreamReader(sourceInputStream));
			
			agent = new AgentBuilder().transport(transport).identity(identity).build();
			
			helloWorldProxy = ProxyBuilder.create(agent, Principal.fromString(icCanister))
					.getProxy(HelloWorldProxy.class);

			value = "ed25519";
			
			proxyResponse = helloWorldProxy.greet(value);
			
			output = proxyResponse.get();
			LOG.info(output);
			
			// Use Secp256k1 Identity
			sourceInputStream = Main.class.getClassLoader().getResourceAsStream(SECP256K1_IDENTITY_FILE);


			identity = Secp256k1Identity.fromPEMFile(new InputStreamReader(sourceInputStream));
			
			agent = new AgentBuilder().transport(transport).identity(identity).build();
			
			helloWorldProxy = ProxyBuilder.create(agent, Principal.fromString(icCanister))
					.getProxy(HelloWorldProxy.class);

			value = "secp256k1";
			
			proxyResponse = helloWorldProxy.greet(value);
			
			output = proxyResponse.get();
			LOG.info(output);			

		} catch (Throwable e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}

}
