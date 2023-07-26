package org.ic4j.origyn.nft;

import java.lang.Boolean;
import java.lang.Object;
import java.lang.String;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class ManageCollectionCommandUpdateMetadataValue {
  @Name("0")
  @Field(Type.TEXT)
  public String field0;

  @Name("1")
  @Field(Type.RESERVED)
  public Optional<Object> field1;

  @Name("2")
  @Field(Type.BOOL)
  public Boolean field2;
}
