package org.ic4j.origyn.nft;

import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class GetMetricsParameters {
  @Name("dateToMillis")
  @Field(Type.NAT)
  public BigInteger dateToMillis;

  @Name("granularity")
  @Field(Type.VARIANT)
  public MetricsGranularity granularity;

  @Name("dateFromMillis")
  @Field(Type.NAT)
  public BigInteger dateFromMillis;
}
