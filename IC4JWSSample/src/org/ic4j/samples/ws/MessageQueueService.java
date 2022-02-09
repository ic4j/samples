package org.ic4j.samples.ws;

import java.util.logging.Logger;

import javax.json.Json;
import javax.json.JsonObject;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

public class MessageQueueService implements Service {
	private static final Logger LOGGER = Logger.getLogger(MessageQueueService.class.getName());
	
	private final MessageQueue messageQueue = MessageQueue.instance();
	
	HelloProxy demoProxy;
	  
	MessageQueueService(HelloProxy demoProxy)
	{
		super();
		this.demoProxy = demoProxy;
	}
	
	    @Override
	    public void update(Routing.Rules routingRules) {
	    	routingRules.get("/peek", this::handlePeek);
	        routingRules.post("/greet", this::handleGreet);
	    }
	    
	    private void handlePeek(ServerRequest request, ServerResponse response) {
	    	response.send(Json.createObjectBuilder()
				     .add("name",this.demoProxy.peek()).build());
	    }
	    
	    private void handleGreet(ServerRequest request, ServerResponse response) {
	    	request.content().as(JsonObject.class).thenAccept(payload -> {
	    		String name = payload.getString("name");
	    		LOGGER.info(name);
	    		
	    		demoProxy.greet(name).whenComplete((output,ex) -> {
	    			LOGGER.info(output);
	    			messageQueue.push(output);
	    		});
	    	});
	        response.status(204).send();
	    }	    
	}

