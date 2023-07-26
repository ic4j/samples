package org.ic4j.samples.origyn;

import java.io.InputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Security;
import java.util.Properties;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.ic4j.agent.Agent;
import org.ic4j.agent.AgentBuilder;
import org.ic4j.agent.ProxyBuilder;
import org.ic4j.agent.ReplicaTransport;
import org.ic4j.agent.http.ReplicaApacheHttpTransport;
import org.ic4j.agent.identity.BasicIdentity;
import org.ic4j.agent.identity.Identity;
import org.ic4j.origyn.nft.Account;
import org.ic4j.origyn.nft.BalanceResult;
import org.ic4j.origyn.nft.OrigynProxy;
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

		ReplicaTransport transport = ReplicaApacheHttpTransport.create(icLocation);
		Agent agent = new AgentBuilder().transport(transport).identity(identity).build();
		
		agent.fetchRootKey();

		Account account = Account.principal;
		account.principalValue = Principal.fromString("6i6da-t3dfv-vteyg-v5agl-tpgrm-63p4y-t5nmm-gi7nl-o72zu-jd3sc-7qe");
		

		OrigynProxy origynProxy = ProxyBuilder.create(agent, Principal.fromString(icCanister))
		.getProxy(OrigynProxy.class);
		
		BalanceResult balance = origynProxy.balance_of_nft_origyn(account);
		
		
		LOG.info("Balance Result " + balance.name());
		
		
		} catch (Throwable e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}

}
