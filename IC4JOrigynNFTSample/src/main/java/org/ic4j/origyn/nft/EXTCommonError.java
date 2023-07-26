package org.ic4j.origyn.nft;

import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum EXTCommonError {
  InvalidToken,

  Other;

  @Name("InvalidToken")
  @Field(Type.TEXT)
  public String invalidTokenValue;

  @Name("Other")
  @Field(Type.TEXT)
  public String otherValue;
}
