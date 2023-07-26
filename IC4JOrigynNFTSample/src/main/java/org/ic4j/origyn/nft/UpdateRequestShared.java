package org.ic4j.origyn.nft;

import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class UpdateRequestShared {
  @Name("id")
  @Field(Type.TEXT)
  public String id;

  @Name("update")
  @Field(Type.RECORD)
  public UpdateShared[] update;
}
