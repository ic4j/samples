package org.ic4j.origyn.nft;

import java.lang.Boolean;
import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class DataClassValue {
  @Name("value")
  @Field(Type.VARIANT)
  public CandyShared value;

  @Name("name")
  @Field(Type.TEXT)
  public String name;

  @Name("immutable")
  @Field(Type.BOOL)
  public Boolean immutable;
}
