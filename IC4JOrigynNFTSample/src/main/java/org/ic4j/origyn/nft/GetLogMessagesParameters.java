package org.ic4j.origyn.nft;

import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class GetLogMessagesParameters {
  @Name("count")
  @Field(Type.NAT32)
  public Integer count;

  @Name("filter")
  @Field(Type.RESERVED)
  public Optional<Object> filter;

  @Name("fromTimeNanos")
  @Field(Type.NAT64)
  public Optional<Long> fromTimeNanos;
}
