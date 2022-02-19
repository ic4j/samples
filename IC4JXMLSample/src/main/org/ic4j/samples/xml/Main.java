package org.ic4j.samples.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.ic4j.agent.Agent;
import org.ic4j.agent.AgentBuilder;
import org.ic4j.agent.ReplicaTransport;
import org.ic4j.agent.UpdateBuilder;
import org.ic4j.agent.Waiter;
import org.ic4j.agent.http.ReplicaApacheHttpTransport;
import org.ic4j.candid.dom.DOMDeserializer;
import org.ic4j.candid.dom.DOMSerializer;
import org.ic4j.candid.dom.DOMUtils;
import org.ic4j.candid.parser.IDLArgs;
import org.ic4j.candid.parser.IDLType;
import org.ic4j.candid.parser.IDLValue;
import org.ic4j.candid.types.Label;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Main {
	static String PROPERTIES_FILE_NAME = "application.properties";
	static final String LOAN_APPLICATION_FILE = "LoanApplication.xml";

    static Logger LOG = LoggerFactory.getLogger(Main.class);
    
	// Instantiate the Factory
	static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    
	public static void main(String[] args) {
		try {
			
		dbf.setNamespaceAware(true);
		dbf.setIgnoringElementContentWhitespace(true);	
		
		InputStream propInputStream = Main.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);

		Properties env = new Properties();
		env.load(propInputStream);

		String icLocation = env.getProperty("ic.location");
		String icCanister = env.getProperty("ic.canister");

		ReplicaTransport transport = ReplicaApacheHttpTransport.create(icLocation);
		Agent agent = new AgentBuilder().transport(transport).build();
		
		Map<Label,IDLType> offerRecord = new TreeMap<Label,IDLType>();
		offerRecord.put(Label.createNamedLabel("providerid"), IDLType.createType(Type.PRINCIPAL));
		offerRecord.put(Label.createNamedLabel("providername"), IDLType.createType(Type.TEXT));
		offerRecord.put(Label.createNamedLabel("applicationid"), IDLType.createType(Type.NAT));	
		offerRecord.put(Label.createNamedLabel("apr"), IDLType.createType(Type.FLOAT64));		
		offerRecord.put(Label.createNamedLabel("created"), IDLType.createType(Type.INT));
		
		IDLType resultIdlType =  IDLType.createType(Type.RECORD, offerRecord);			
		
		Element xmlValue = readNode(LOAN_APPLICATION_FILE);
		
		LOG.info(DOMUtils.getStringFromDocument(xmlValue.getOwnerDocument()));
		
		IDLValue idlValue = IDLValue.create(xmlValue, DOMSerializer.create());
		
		List<IDLValue> idlArgs = new ArrayList<IDLValue>();
		
		idlArgs.add(idlValue);

		byte[] buf = IDLArgs.create(idlArgs).toBytes();
		
		CompletableFuture<byte[]> response = UpdateBuilder.create(agent,Principal.fromString(icCanister), "apply").arg(buf).callAndWait(Waiter.create(60, 5));
		
		byte[] output = response.get();
		Element  xmlResult = IDLArgs.fromBytes(output).getArgs().get(0)
				.getValue(DOMDeserializer.create(resultIdlType)
						.rootElement("http://ic4j.org/samples", "data").setAttributes(true), Element.class);

		String result = DOMUtils.getStringFromDocument(xmlResult.getOwnerDocument());
		LOG.info(result);
		
		} catch (Throwable e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}
	
	static Element readNode(String fileName) throws SAXException, IOException, ParserConfigurationException {
		// parse XML file
		DocumentBuilder db = dbf.newDocumentBuilder();

		Document doc = db.parse(Main.class.getClassLoader().getResource(fileName).getFile());

		return doc.getDocumentElement();
	}

}
