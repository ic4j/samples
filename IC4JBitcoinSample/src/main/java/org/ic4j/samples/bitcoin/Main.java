package org.ic4j.samples.bitcoin;

import java.io.InputStream;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

import org.ic4j.agent.Agent;
import org.ic4j.agent.AgentBuilder;
import org.ic4j.agent.ProxyBuilder;
import org.ic4j.agent.ReplicaTransport;
import org.ic4j.agent.http.ReplicaApacheHttpTransport;
import org.ic4j.bitcoin.BitcoinService;
import org.ic4j.bitcoin.GetBalanceRequest;
import org.ic4j.bitcoin.GetUtxosRequest;
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

			String bitcoinLocation = env.getProperty("bitcoin.location");
			String bitcoinAddress = env.getProperty("bitcoin.address");

			ReplicaTransport transport = ReplicaApacheHttpTransport.create(bitcoinLocation);
			Agent agent = new AgentBuilder().transport(transport).build();
			
			BitcoinService bitcoinService = BitcoinService.create(agent, env);
			
			GetBalanceRequest balanceRequest = new GetBalanceRequest();
			balanceRequest.address = bitcoinAddress;
			
			LOG.info(bitcoinService.getBalance(balanceRequest).get().toString());	
			
			GetUtxosRequest utxosRequest = new GetUtxosRequest();
			utxosRequest.address = bitcoinAddress;
			utxosRequest.minConfirmations = Optional.empty();
			utxosRequest.offset = Optional.empty();
							
			LOG.info(bitcoinService.getUtxos(utxosRequest).get().totalCount.toString());			

		} catch (Throwable e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}

}
