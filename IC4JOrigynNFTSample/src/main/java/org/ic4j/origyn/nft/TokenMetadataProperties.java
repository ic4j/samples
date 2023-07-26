package org.ic4j.origyn.nft;

import java.lang.Object;
import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class TokenMetadataProperties {
  @Name("0")
  @Field(Type.TEXT)
  public String field0;

  @Name("1")
  @Field(Type.RESERVED)
  public Object field1;
}
