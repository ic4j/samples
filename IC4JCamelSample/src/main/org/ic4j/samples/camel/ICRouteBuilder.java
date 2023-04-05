package org.ic4j.samples.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaConstants;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * A Camel Java Kafka to IC Router
 */
public class ICRouteBuilder extends RouteBuilder {
	static final String LOAN_APPLICATION_FILE = "LoanApplication.json";

    static Logger LOG = LoggerFactory.getLogger(ICRouteBuilder.class);
    
    /**
     * Let's configure the Camel routing rules using Java code 
     */
    @Override
    public void configure() throws Exception {    	
        // Kafka Producer using Message key
    	   	
        from("file:src/data?noop=true")
                 .setHeader(KafkaConstants.KEY, constant("Camel")) 
                .to("kafka:icTopic?brokers=localhost:9092");
        
        // Kafka Consumer to Internet Computer canister
        from("kafka:icTopic?brokers=localhost:9092")
                .log("Loan Application received from Kafka : ${body}")
                .log("    on the topic ${headers[kafka.TOPIC]}")
                .log("    on the partition ${headers[kafka.PARTITION]}")
                .log("    with the offset ${headers[kafka.OFFSET]}")
                .log("    with the key ${headers[kafka.KEY]}")
                .unmarshal().json(JsonLibrary.Jackson,LoanApplication.class)
                .log("First Name : ${body.firstName}")
                .log("Last Name : ${body.lastName}")
                .log("Amount : ${body.amount}")                
                .to("ic:update?url={{ic.location}}&method=apply&canisterId={{ic.canister}}&outClass=org.ic4j.samples.camel.LoanOffer")
                .log("Loan Offer APR : ${body.apr}")
                .marshal().json(JsonLibrary.Jackson,LoanOffer.class)
                .log("Loan Offer received from IC : ${body}");
          
    	
        
        
    }
}
