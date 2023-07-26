package org.ic4j.origyn.nft;

import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class DutchConfig {
  @Name("start_price")
  @Field(Type.NAT)
  public BigInteger fieldstart_price;

  @Name("token")
  @Field(Type.VARIANT)
  public TokenSpec token;

  @Name("reserve")
  @Field(Type.NAT)
  public Optional<BigInteger> reserve;

  @Name("start_date")
  @Field(Type.INT)
  public BigInteger fieldstart_date;

  @Name("allow_list")
  @Field(Type.VEC)
  public Optional<Principal[]> fieldallow_list;

  @Name("decay_per_hour")
  @Field(Type.VARIANT)
  public DutchConfigDecay_per_hour fielddecay_per_hour;
}
