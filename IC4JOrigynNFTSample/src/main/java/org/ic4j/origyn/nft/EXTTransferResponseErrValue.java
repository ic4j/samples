package org.ic4j.origyn.nft;

import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum EXTTransferResponseErrValue {
  CannotNotify,

  InsufficientBalance,

  InvalidToken,

  Rejected,

  Unauthorized,

  Other;

  @Name("CannotNotify")
  @Field(Type.TEXT)
  public String cannotNotifyValue;

  @Name("InvalidToken")
  @Field(Type.TEXT)
  public String invalidTokenValue;

  @Name("Unauthorized")
  @Field(Type.TEXT)
  public String unauthorizedValue;

  @Name("Other")
  @Field(Type.TEXT)
  public String otherValue;
}
