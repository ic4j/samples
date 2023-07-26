package org.ic4j.origyn.nft;

import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class CanisterLogMessagesInfo {
  @Name("features")
  @Field(Type.OPT)
  public Optional<Object>[] features;

  @Name("lastTimeNanos")
  @Field(Type.NAT64)
  public Optional<Long> lastTimeNanos;

  @Name("count")
  @Field(Type.NAT32)
  public Integer count;

  @Name("firstTimeNanos")
  @Field(Type.NAT64)
  public Optional<Long> firstTimeNanos;
}
