package org.ic4j.origyn.nft;

import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class StableBucketDataVersion {
  @Name("0")
  @Field(Type.NAT)
  public BigInteger field0;

  @Name("1")
  @Field(Type.NAT)
  public BigInteger field1;

  @Name("2")
  @Field(Type.NAT)
  public BigInteger field2;
}
