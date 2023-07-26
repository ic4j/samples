package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum Back_upResponse {
  eof,

  data;

  @Name("eof")
  @Field(Type.RECORD)
  public NFTBackupChunk eofValue;

  @Name("data")
  @Field(Type.RECORD)
  public NFTBackupChunk dataValue;
}
