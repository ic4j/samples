package org.ic4j.origyn.nft;

import java.lang.Object;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class NFTBackupChunkAllocations {
  @Name("0")
  @Field(Type.RECORD)
  public NFTBackupChunkAllocations0 field0;

  @Name("1")
  @Field(Type.RESERVED)
  public Object field1;
}
