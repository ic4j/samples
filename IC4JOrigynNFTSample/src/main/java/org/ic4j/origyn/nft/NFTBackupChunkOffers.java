package org.ic4j.origyn.nft;

import java.lang.Object;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class NFTBackupChunkOffers {
  @Name("0")
  @Field(Type.RESERVED)
  public Object field0;

  @Name("1")
  @Field(Type.RESERVED)
  public Object field1;

  @Name("2")
  @Field(Type.INT)
  public BigInteger field2;
}
