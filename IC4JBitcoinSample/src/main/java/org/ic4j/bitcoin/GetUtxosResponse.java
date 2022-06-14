package org.ic4j.bitcoin;

import java.util.Optional;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum GetUtxosResponse {
	Ok,Err;
	
    @Name("Ok")
    @Field(Type.RECORD)	
	public UtxosValue okValue;
    
    @Name("Err")
    @Field(Type.VARIANT)	
	public Optional<GetUtxosError> errValue;    
	
}
