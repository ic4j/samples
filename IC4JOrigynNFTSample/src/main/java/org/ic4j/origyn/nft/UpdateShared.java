package org.ic4j.origyn.nft;

import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class UpdateShared {
  @Name("mode")
  @Field(Type.VARIANT)
  public UpdateModeShared mode;

  @Name("name")
  @Field(Type.TEXT)
  public String name;
}
