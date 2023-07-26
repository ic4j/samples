package org.ic4j.origyn.nft;

import java.lang.Long;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class CanisterLogMessages {
  @Name("data")
  @Field(Type.RECORD)
  public LogMessagesData[] data;

  @Name("lastAnalyzedMessageTimeNanos")
  @Field(Type.NAT64)
  public Optional<Long> lastAnalyzedMessageTimeNanos;
}
