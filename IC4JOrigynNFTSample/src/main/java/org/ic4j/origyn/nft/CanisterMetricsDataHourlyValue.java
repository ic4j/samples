package org.ic4j.origyn.nft;

import java.lang.Long;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class CanisterMetricsDataHourlyValue {
  @Name("updateCalls")
  @Field(Type.NAT64)
  public Long[] updateCalls;

  @Name("canisterHeapMemorySize")
  @Field(Type.NAT64)
  public Long[] canisterHeapMemorySize;

  @Name("canisterCycles")
  @Field(Type.NAT64)
  public Long[] canisterCycles;

  @Name("canisterMemorySize")
  @Field(Type.NAT64)
  public Long[] canisterMemorySize;

  @Name("timeMillis")
  @Field(Type.INT)
  public BigInteger timeMillis;
}
