package org.ic4j.origyn.nft;

import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class ShareWalletRequest {
  @Name("to")
  @Field(Type.VARIANT)
  public Account to;

  @Name("token_id")
  @Field(Type.TEXT)
  public String fieldtoken_id;

  @Name("from")
  @Field(Type.VARIANT)
  public Account from;
}
