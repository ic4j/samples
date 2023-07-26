package org.ic4j.origyn.nft;

import java.lang.String;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class ICTokenSpec {
  @Name("id")
  @Field(Type.NAT)
  public Optional<BigInteger> id;

  @Name("fee")
  @Field(Type.NAT)
  public Optional<BigInteger> fee;

  @Name("decimals")
  @Field(Type.NAT)
  public BigInteger decimals;

  @Name("canister")
  @Field(Type.PRINCIPAL)
  public Principal canister;

  @Name("standard")
  @Field(Type.VARIANT)
  public ICTokenSpecStandard standard;

  @Name("symbol")
  @Field(Type.TEXT)
  public String symbol;
}
