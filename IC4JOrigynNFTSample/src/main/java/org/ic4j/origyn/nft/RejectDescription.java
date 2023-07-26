package org.ic4j.origyn.nft;

import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class RejectDescription {
  @Name("token")
  @Field(Type.VARIANT)
  public TokenSpec token;

  @Name("token_id")
  @Field(Type.TEXT)
  public String fieldtoken_id;

  @Name("seller")
  @Field(Type.VARIANT)
  public Account seller;

  @Name("buyer")
  @Field(Type.VARIANT)
  public Account buyer;
}
