package org.ic4j.origyn.nft;

import java.lang.Double;
import java.lang.Long;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class AuctionConfigEndingWaitForQuietValue {
  @Name("max")
  @Field(Type.NAT)
  public BigInteger max;

  @Name("date")
  @Field(Type.INT)
  public BigInteger date;

  @Name("fade")
  @Field(Type.FLOAT64)
  public Double fade;

  @Name("extention")
  @Field(Type.NAT64)
  public Long extention;
}
