package org.ic4j.samples.jaxb;

import java.io.InputStream;
import java.util.Properties;

import javax.xml.bind.JAXBContext;

import org.ic4j.agent.Agent;
import org.ic4j.agent.AgentBuilder;
import org.ic4j.agent.ProxyBuilder;
import org.ic4j.agent.ReplicaTransport;
import org.ic4j.agent.http.ReplicaJavaHttpTransport;
import org.ic4j.types.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	static String PROPERTIES_FILE_NAME = "application.properties";
	static final String LOAN_APPLICATION_FILE = "LoanApplication.xml";

    static Logger LOG = LoggerFactory.getLogger(Main.class);
    
	public static void main(String[] args) {
		try {
		InputStream propInputStream = Main.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);

		Properties env = new Properties();
		env.load(propInputStream);

		String icLocation = env.getProperty("ic.location");
		String icCanister = env.getProperty("ic.canister");

		ReplicaTransport transport = ReplicaJavaHttpTransport.create(icLocation);
		Agent agent = new AgentBuilder().transport(transport).build();
		
		LoanProxy loanProxy = ProxyBuilder.create(agent, Principal.fromString(icCanister))
				.getProxy(LoanProxy.class);
		
	    JAXBContext context = JAXBContext.newInstance(LoanApplication.class);
	    LoanApplication loanApplication =  (LoanApplication) context.createUnmarshaller()		
	      .unmarshal(Main.class.getClassLoader().getResourceAsStream(LOAN_APPLICATION_FILE));
	    
	    LoanOffer loanOffer = loanProxy.apply(loanApplication).get();
		
		LOG.info(loanOffer.apr.toString());
		
		} catch (Throwable e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}
	

}
