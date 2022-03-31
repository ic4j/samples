package org.ic4j.samples.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;

import javax.imageio.ImageIO;

import org.ic4j.agent.Agent;
import org.ic4j.agent.AgentBuilder;
import org.ic4j.agent.ProxyBuilder;
import org.ic4j.agent.ReplicaTransport;
import org.ic4j.agent.UpdateBuilder;
import org.ic4j.agent.Waiter;
import org.ic4j.agent.http.ReplicaApacheHttpTransport;
import org.ic4j.candid.jackson.JacksonDeserializer;
import org.ic4j.candid.jackson.JacksonSerializer;
import org.ic4j.candid.parser.IDLArgs;
import org.ic4j.candid.parser.IDLType;
import org.ic4j.candid.parser.IDLValue;
import org.ic4j.candid.types.Label;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {
	static String PROPERTIES_FILE_NAME = "application.properties";
	static final String IMAGE_FILE = "dfinity.png";

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
		
		
		byte[] image = getImage(IMAGE_FILE, "png");
		
		LOG.info("Source Image Size " + Integer.toString(image.length));
		
		String name  = IMAGE_FILE;
		
		ImagesProxy images = ProxyBuilder.create(agent, Principal.fromString(icCanister))
				.getProxy(ImagesProxy.class);

		
		CompletableFuture<String> proxyResponse = images.add(name, image);

		String output = proxyResponse.get();
		
		byte[] imageResult = images.get(name);		

		LOG.info("Result Image Size " + Integer.toString(imageResult.length));
		
		} catch (Throwable e) {
			LOG.error(e.getLocalizedMessage(), e);
		}
	}
	
	static byte[] getImage(String fileName, String type) throws Exception{
		InputStream binaryInputStream = Main.class.getClassLoader().getResourceAsStream(fileName);

		BufferedImage bImage = ImageIO.read(binaryInputStream);
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(bImage, type , bos );
		byte [] data = bos.toByteArray();
		 
		return data;
	}

}
