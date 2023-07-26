package org.ic4j.origyn.nft;

import java.lang.Boolean;
import java.lang.Double;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class NiftyConfig {
  @Name("fixed")
  @Field(Type.BOOL)
  public Boolean fixed;

  @Name("interestRatePerSecond")
  @Field(Type.FLOAT64)
  public Double interestRatePerSecond;

  @Name("token")
  @Field(Type.VARIANT)
  public TokenSpec token;

  @Name("duration")
  @Field(Type.INT)
  public Optional<BigInteger> duration;

  @Name("expiration")
  @Field(Type.INT)
  public Optional<BigInteger> expiration;

  @Name("amount")
  @Field(Type.NAT)
  public BigInteger amount;

  @Name("lenderOffer")
  @Field(Type.BOOL)
  public Boolean lenderOffer;
}
