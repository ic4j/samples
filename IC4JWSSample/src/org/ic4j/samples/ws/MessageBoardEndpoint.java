package org.ic4j.samples.ws;

import java.util.logging.Logger;

import javax.json.Json;
import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

public class MessageBoardEndpoint extends Endpoint {
    private static final Logger LOGGER = Logger.getLogger(MessageBoardEndpoint.class.getName());

    private final MessageQueue messageQueue = MessageQueue.instance();

    @Override
    public void onOpen(Session session, EndpointConfig endpointConfig) {
    	LOGGER.info(endpointConfig.toString());
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String message) {
                try {
                    // Send all messages in the queue
                    if (message.equals("SEND")) {
                        while (!messageQueue.isEmpty()) {
                        	String greeting = messageQueue.pop();                 	
                            session.getBasicRemote().sendObject(Json.createObjectBuilder()
                  				     .add("message", greeting).build());
                        }
                    }
                } catch (Exception e) {
                    LOGGER.info(e.getMessage());
                }
            }
        });
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        super.onClose(session, closeReason);
    }

    @Override
    public void onError(Session session, Throwable thr) {
        super.onError(session, thr);
    }
}
