package org.ic4j.samples.bitcoin;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

import org.ic4j.agent.Agent;
import org.ic4j.agent.AgentBuilder;
import org.ic4j.agent.ProxyBuilder;
import org.ic4j.agent.ReplicaTransport;
import org.ic4j.agent.http.ReplicaApacheHttpTransport;
import org.ic4j.candid.types.Label;
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
			String btcAddress = env.getProperty("btc.address");

			ReplicaTransport transport = ReplicaApacheHttpTransport.create(icLocation);
			Agent agent = new AgentBuilder().transport(transport).build();
			
			BitcoinProxy bitcoinProxy = ProxyBuilder.create(agent, Principal.fromString(icCanister))
					.getProxy(BitcoinProxy.class);

			GetBalanceRequest balanceRequest = new GetBalanceRequest();
			balanceRequest.address = btcAddress;
			
			CompletableFuture<Map<Label,Object>> proxyResponse = bitcoinProxy.getBalance(balanceRequest);
			
			Map<Label,Object> output = proxyResponse.get();
			
			Label okLabel = Label.createNamedLabel("Ok");
			
			if(output.containsKey(okLabel))
				LOG.info(output.get(okLabel).toString());


		} catch (Throwable e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}

}
