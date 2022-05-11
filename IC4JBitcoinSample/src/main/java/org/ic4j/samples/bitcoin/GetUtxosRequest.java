package org.ic4j.samples.bitcoin;

import java.util.Optional;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class GetUtxosRequest {
    @Name("address")
    public String address;
    @Name("min_confirmations")
    @Field(Type.NAT32)
    public Optional<Integer> minConfirmations;
    @Name("offset")
    @Field(Type.NAT32)
    public Optional<Integer> offset;    
}
