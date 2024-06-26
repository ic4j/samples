package org.ic4j.samples.pojo;

import java.io.InputStream;
import java.math.BigInteger;
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
import org.ic4j.agent.http.ReplicaJavaHttpTransport;
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
		
		Security.addProvider(new BouncyCastleProvider());

		KeyPair keyPair = KeyPairGenerator.getInstance("Ed25519").generateKeyPair();

		Identity identity = BasicIdentity.fromKeyPair(keyPair);

		ReplicaTransport transport = ReplicaJavaHttpTransport.create(icLocation);
		Agent agent = new AgentBuilder().transport(transport).identity(identity).build();

		LoanApplication loanApplication = new LoanApplication();
		loanApplication.firstName = "John";
		loanApplication.lastName = "Doe";
		loanApplication.ssn = "111-11-1111";
		loanApplication.term = 48;
		loanApplication.zipcode = "95134";		
		loanApplication.amount = (double) 20000.00;
		loanApplication.id = new BigInteger("11");
		loanApplication.created = new BigInteger("0");
		

		LoanProxy loanProxy = ProxyBuilder.create(agent, Principal.fromString(icCanister))
		.getProxy(LoanProxy.class);
		
		CompletableFuture<LoanOffer> response = loanProxy.apply(loanApplication);
		
		LoanOffer loanOffer = response.get();		
		
		LOG.info("Loan Offer APR is " + loanOffer.apr);
		
		LoanOffer[] loanOffers = loanProxy.getOffers();
		
		LOG.info("Number of Offers is " + loanOffers.length);
		
		} catch (Throwable e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}

}
