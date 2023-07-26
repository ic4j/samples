package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum StreamingStrategy {
  Callback;

  @Name("Callback")
  @Field(Type.RECORD)
  public StreamingStrategyCallbackValue callbackValue;
}
