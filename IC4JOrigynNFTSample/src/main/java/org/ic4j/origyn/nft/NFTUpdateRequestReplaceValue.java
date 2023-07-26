package org.ic4j.origyn.nft;

import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class NFTUpdateRequestReplaceValue {
  @Name("token_id")
  @Field(Type.TEXT)
  public String fieldtoken_id;

  @Name("data")
  @Field(Type.VARIANT)
  public CandyShared data;
}
