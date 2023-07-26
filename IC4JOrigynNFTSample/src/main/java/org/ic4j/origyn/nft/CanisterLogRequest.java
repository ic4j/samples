package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum CanisterLogRequest {
  getMessagesInfo,

  getMessages,

  getLatestMessages;

  @Name("getMessages")
  @Field(Type.RECORD)
  public GetLogMessagesParameters getMessagesValue;

  @Name("getLatestMessages")
  @Field(Type.RECORD)
  public GetLatestLogMessagesParameters getLatestMessagesValue;
}
