package org.ic4j.bitcoin;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class UtxosValue {

    @Name("utxos")
    @Field(Type.RECORD)
	public Utxos[] utxos;
	
    @Name("total_count")
    @Field(Type.NAT32)
	public Integer totalCount;
}
