package org.ic4j.origyn.nft;

import java.lang.Double;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum AuctionConfigMin_increase {
  amount,

  percentage;

  @Name("amount")
  @Field(Type.NAT)
  public BigInteger amountValue;

  @Name("percentage")
  @Field(Type.FLOAT64)
  public Double percentageValue;
}
