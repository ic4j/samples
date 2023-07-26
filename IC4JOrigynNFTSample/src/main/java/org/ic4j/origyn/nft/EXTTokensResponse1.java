package org.ic4j.origyn.nft;

import java.lang.Long;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class EXTTokensResponse1 {
  @Name("locked")
  @Field(Type.INT)
  public Optional<BigInteger> locked;

  @Name("seller")
  @Field(Type.PRINCIPAL)
  public Principal seller;

  @Name("price")
  @Field(Type.NAT64)
  public Long price;
}
