package org.ic4j.samples.swift;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

import org.ic4j.agent.Agent;
import org.ic4j.agent.AgentBuilder;
import org.ic4j.agent.ProxyBuilder;
import org.ic4j.agent.ReplicaTransport;
import org.ic4j.agent.http.ReplicaApacheHttpTransport;
import org.ic4j.types.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.prowidesoftware.swift.model.mx.MxPacs00800107;
import com.prowidesoftware.swift.model.mx.MxPacs00900109;
import com.prowidesoftware.swift.model.mx.dic.ActiveCurrencyAndAmount;
import com.prowidesoftware.swift.model.mx.dic.FIToFICustomerCreditTransferV07;
import com.prowidesoftware.swift.model.mx.dic.FinancialInstitutionCreditTransferV09;
import com.prowidesoftware.swift.utils.Lib;

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
			Agent agent = new AgentBuilder().transport(transport).build();
			
			agent.fetchRootKey();
			
			SwiftProxy swiftProxy = ProxyBuilder.create(agent, Principal.fromString(icCanister))
					.getProxy(SwiftProxy.class);

		       // parse the XML message content from a resource file
	        MxPacs00800107 mx07 = MxPacs00800107.parse(Lib.readResource("pacs.008.001.07.xml"));

	        // access message header data from the java model
	        LOG.info("Header from: " + mx07.getAppHdr().from());
	        LOG.info("Header to: " + mx07.getAppHdr().to());
	        LOG.info("Header reference: " + mx07.getAppHdr().reference());

	        // notice the from/to methods in the generic model will only return values when the header BIC option is
	        // present. For other structure options such as reading a ClrSysMmbId you can further cast this to a specific
	        // AppHdr implementation. The AppHdr is just an interface.

	        // access message document data from the java model
	        
	        FIToFICustomerCreditTransferV07 request = mx07.getFIToFICstmrCdtTrf();
	        
			
			CompletableFuture<FIToFICustomerCreditTransferV07> proxyRequestResponse = swiftProxy.reversalRequest(request);
			
			
			FIToFICustomerCreditTransferV07 requestResponse = proxyRequestResponse.get();
	        ActiveCurrencyAndAmount amount = requestResponse.getCdtTrfTxInf().get(0).getIntrBkSttlmAmt();
	        
	        LOG.info("Amount: " + amount.getCcy() + " " + amount.getValue()); 
	        
	        //Verify XML Content
	        String xmlContent = mx07.document();
	          
	        LOG.info(xmlContent);	        

	        mx07.setFIToFICstmrCdtTrf(requestResponse);
	           
	        //Verify XML Content
	        xmlContent = mx07.document();
	          
	        LOG.info(xmlContent);
	        
	        // parse the XML message content from a resource file
	        MxPacs00900109 mx09 = MxPacs00900109.parse(Lib.readResource("pacs.009.001.09.xml"));
	        
	        FinancialInstitutionCreditTransferV09 credit = mx09.getFICdtTrf();
	        
			CompletableFuture<FinancialInstitutionCreditTransferV09> proxyCreditResponse = swiftProxy.creditTransfer(credit);
			
			FinancialInstitutionCreditTransferV09 creditResponse = proxyCreditResponse.get();
	        amount = creditResponse.getCdtTrfTxInf().get(0).getIntrBkSttlmAmt();
	        
	        LOG.info("Amount: " + amount.getCcy() + " " + amount.getValue()); 
	        
	        //Verify XML Content
	         xmlContent = mx09.document();
	          
	        LOG.info(xmlContent);	        

	        mx09.setFICdtTrf(creditResponse);
	           
	        //Verify XML Content
	        xmlContent = mx09.document();
	          
	        LOG.info(xmlContent);			
	        
		} catch (Throwable e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}

}
