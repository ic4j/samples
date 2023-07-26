package org.ic4j.origyn.nft;

import java.lang.Double;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum DutchConfigDecay_per_hour {
  flat,

  percent;

  @Name("flat")
  @Field(Type.NAT)
  public BigInteger flatValue;

  @Name("percent")
  @Field(Type.FLOAT64)
  public Double percentValue;
}
