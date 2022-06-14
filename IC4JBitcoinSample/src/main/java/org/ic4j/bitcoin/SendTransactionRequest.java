package org.ic4j.bitcoin;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class SendTransactionRequest {
    @Name("transaction")
    @Field(Type.NAT8)
    public byte[] transaction;
}
