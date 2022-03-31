package org.ic4j.samples.helloworld;

import java.io.InputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.ic4j.agent.Agent;
import org.ic4j.agent.AgentBuilder;
import org.ic4j.agent.ProxyBuilder;
import org.ic4j.agent.ReplicaTransport;
import org.ic4j.agent.http.ReplicaApacheHttpTransport;
import org.ic4j.agent.identity.BasicIdentity;
import org.ic4j.agent.identity.Identity;
import org.ic4j.types.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	static String PROPERTIES_FILE_NAME = "application.properties";

	static Logger LOG = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		try {
			InputStream propInputStream = Main.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);

			Properties env = new Properties();
			env.load(propInputStream);

			String icLocation = env.getProperty("ic.location");
			String icCanister = env.getProperty("ic.canister");

			ReplicaTransport transport = ReplicaApacheHttpTransport.create(icLocation);

			
			Security.addProvider(new BouncyCastleProvider());

			KeyPair keyPair = KeyPairGenerator.getInstance("Ed25519").generateKeyPair();

			Identity identity = BasicIdentity.fromKeyPair(keyPair);
			
			Agent agent = new AgentBuilder().transport(transport).identity(identity).build();			
			
			HelloWorldProxy helloWorldProxy = ProxyBuilder.create(agent, Principal.fromString(icCanister))
					.getProxy(HelloWorldProxy.class);

			String output = helloWorldProxy.peek();
			
			LOG.info(output);
			
			String value = "world";
			
			CompletableFuture<String> proxyResponse = helloWorldProxy.greet(value);
			
			output = proxyResponse.get();
			LOG.info(output);


		} catch (Throwable e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}

}
