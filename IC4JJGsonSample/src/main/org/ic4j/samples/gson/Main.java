package org.ic4j.samples.gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;

import org.ic4j.agent.Agent;
import org.ic4j.agent.AgentBuilder;
import org.ic4j.agent.ReplicaTransport;
import org.ic4j.agent.UpdateBuilder;
import org.ic4j.agent.Waiter;
import org.ic4j.agent.http.ReplicaApacheHttpTransport;
import org.ic4j.candid.gson.GsonDeserializer;
import org.ic4j.candid.gson.GsonSerializer;
import org.ic4j.candid.parser.IDLArgs;
import org.ic4j.candid.parser.IDLType;
import org.ic4j.candid.parser.IDLValue;
import org.ic4j.candid.types.Label;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class Main {
	static String PROPERTIES_FILE_NAME = "application.properties";
	static final String LOAN_APPLICATION_FILE = "LoanApplication.json";

    static Logger LOG = LoggerFactory.getLogger(Main.class);
    
	static Gson gson = new Gson();
    
	public static void main(String[] args) {
		try {
		InputStream propInputStream = Main.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);

		Properties env = new Properties();
		env.load(propInputStream);

		String icLocation = env.getProperty("ic.location");
		String icCanister = env.getProperty("ic.canister");

		ReplicaTransport transport = ReplicaApacheHttpTransport.create(icLocation);
		Agent agent = new AgentBuilder().transport(transport).build();
		
		Map<Label,IDLType> applicationRecord = new TreeMap<Label,IDLType>();
		applicationRecord.put(Label.createNamedLabel("id"), IDLType.createType(Type.NAT));
		applicationRecord.put(Label.createNamedLabel("firstname"), IDLType.createType(Type.TEXT));
		applicationRecord.put(Label.createNamedLabel("lastname"), IDLType.createType(Type.TEXT));
		applicationRecord.put(Label.createNamedLabel("zipcode"), IDLType.createType(Type.TEXT));
		applicationRecord.put(Label.createNamedLabel("ssn"), IDLType.createType(Type.TEXT));		
		applicationRecord.put(Label.createNamedLabel("amount"), IDLType.createType(Type.FLOAT64));
		applicationRecord.put(Label.createNamedLabel("term"), IDLType.createType(Type.NAT16));
		applicationRecord.put(Label.createNamedLabel("created"), IDLType.createType(Type.INT));
		
		IDLType idlType =  IDLType.createType(Type.RECORD, applicationRecord);
		
		Map<Label,IDLType> offerRecord = new TreeMap<Label,IDLType>();
		offerRecord.put(Label.createNamedLabel("providerid"), IDLType.createType(Type.PRINCIPAL));
		offerRecord.put(Label.createNamedLabel("providername"), IDLType.createType(Type.TEXT));
		offerRecord.put(Label.createNamedLabel("applicationid"), IDLType.createType(Type.NAT));	
		offerRecord.put(Label.createNamedLabel("apr"), IDLType.createType(Type.FLOAT64));		
		offerRecord.put(Label.createNamedLabel("created"), IDLType.createType(Type.INT));
		
		IDLType resultIdlType =  IDLType.createType(Type.RECORD, offerRecord);	
		
		JsonElement jsonValue = readNode(LOAN_APPLICATION_FILE);
		
		LOG.info(jsonValue.toString());
		
		IDLValue idlValue = IDLValue.create(jsonValue, GsonSerializer.create(idlType));
		
		List<IDLValue> idlArgs = new ArrayList<IDLValue>();
		
		idlArgs.add(idlValue);

		byte[] buf = IDLArgs.create(idlArgs).toBytes();
		
		CompletableFuture<byte[]> response = UpdateBuilder.create(agent,Principal.fromString(icCanister), "apply").arg(buf).callAndWait(Waiter.create(60, 5));
		
		byte[] output = response.get();
		JsonElement jsonResult = IDLArgs.fromBytes(output).getArgs().get(0)
				.getValue(GsonDeserializer.create(resultIdlType), JsonElement.class);

		LOG.info(jsonResult.toString());
		
		} catch (Throwable e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}
	
	static JsonElement readNode(String fileName) throws IOException {
		Reader reader = Files.newBufferedReader(Paths.get(Main.class.getClassLoader().getResource(fileName).getPath()));

		JsonElement rootNode = gson.fromJson(reader, JsonElement.class);
		return rootNode;
	}

}
