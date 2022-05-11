package org.ic4j.samples.bitcoin;

import java.util.Optional;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class GetBalanceRequest {
    @Name("address")
    public String address;
    @Name("min_confirmations")
    @Field(Type.NAT32)
    public Optional<Integer> minConfirmations;
}
