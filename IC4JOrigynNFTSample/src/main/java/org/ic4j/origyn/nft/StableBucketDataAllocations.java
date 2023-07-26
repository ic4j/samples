package org.ic4j.origyn.nft;

import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class StableBucketDataAllocations {
  @Name("0")
  @Field(Type.RECORD)
  public StableBucketDataAllocations0 field0;

  @Name("1")
  @Field(Type.INT)
  public BigInteger field1;
}
