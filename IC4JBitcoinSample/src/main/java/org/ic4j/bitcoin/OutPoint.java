package org.ic4j.bitcoin;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class OutPoint {
    @Name("txid")
    @Field(Type.NAT8)
	public byte[] txid;
    
    @Name("vout")
    @Field(Type.NAT32)
	public Integer vout;
}
