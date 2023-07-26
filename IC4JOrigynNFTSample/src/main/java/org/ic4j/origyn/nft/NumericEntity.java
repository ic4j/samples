package org.ic4j.origyn.nft;

import java.lang.Long;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class NumericEntity {
  @Name("avg")
  @Field(Type.NAT64)
  public Long avg;

  @Name("max")
  @Field(Type.NAT64)
  public Long max;

  @Name("min")
  @Field(Type.NAT64)
  public Long min;

  @Name("first")
  @Field(Type.NAT64)
  public Long first;

  @Name("last")
  @Field(Type.NAT64)
  public Long last;
}
