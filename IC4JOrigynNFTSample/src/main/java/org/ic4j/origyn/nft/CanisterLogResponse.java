package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum CanisterLogResponse {
  messagesInfo,

  messages;

  @Name("messagesInfo")
  @Field(Type.RECORD)
  public CanisterLogMessagesInfo messagesInfoValue;

  @Name("messages")
  @Field(Type.RECORD)
  public CanisterLogMessages messagesValue;
}
