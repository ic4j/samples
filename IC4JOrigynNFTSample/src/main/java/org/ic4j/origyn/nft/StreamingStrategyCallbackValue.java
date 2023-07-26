package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Func;

public class StreamingStrategyCallbackValue {
  @Name("token")
  @Field(Type.RECORD)
  public StreamingCallbackToken token;

  @Name("callback")
  @Field(Type.FUNC)
  public Func callback;
}
