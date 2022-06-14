package org.ic4j.bitcoin;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class Utxos {
    @Name("outpoint")
    @Field(Type.RECORD)	    
    OutPoint outpoint;
    
    @Name("value")
    @Field(Type.NAT64)	
	public Long value;
 
    @Name("height")
    @Field(Type.NAT32)	    
    Integer height;
    
    @Name("confirmations")
    @Field(Type.NAT32)	    
    Integer confirmations;    
}
