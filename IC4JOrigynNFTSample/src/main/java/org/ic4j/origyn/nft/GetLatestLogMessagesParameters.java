package org.ic4j.origyn.nft;

import java.lang.Integer;
import java.lang.Long;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class GetLatestLogMessagesParameters {
  @Name("upToTimeNanos")
  @Field(Type.NAT64)
  public Optional<Long> upToTimeNanos;

  @Name("count")
  @Field(Type.NAT32)
  public Integer count;

  @Name("filter")
  @Field(Type.RECORD)
  public Optional<GetLogMessagesFilter> filter;
}
