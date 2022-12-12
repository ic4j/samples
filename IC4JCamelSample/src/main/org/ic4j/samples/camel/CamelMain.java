package org.ic4j.samples.camel;

import org.apache.camel.main.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CamelMain {

    static Logger LOG = LoggerFactory.getLogger(CamelMain.class);
    
    
	public static void main(String[] args) {			
	    try {
			System.setProperty("mail.imaps.ssl.trust", "*"); 	    	
		    Main main = new Main();
		    //main.configure().addRoutesBuilder(new ICRouteBuilder());
			main.run(args);
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(),e);
		}
	        
	}

}
