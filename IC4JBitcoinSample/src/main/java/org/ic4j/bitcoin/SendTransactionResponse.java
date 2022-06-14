package org.ic4j.bitcoin;

import java.util.Optional;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum SendTransactionResponse {
	Ok,Err;
	
    @Name("Ok")
    @Field(Type.NULL)	
	public Object okValue;
    
    @Name("Err")
    @Field(Type.VARIANT)	
	public Optional<SendTransactionError> errValue;    
	
}
