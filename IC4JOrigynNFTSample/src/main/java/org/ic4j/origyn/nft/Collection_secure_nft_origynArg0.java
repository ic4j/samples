package org.ic4j.origyn.nft;

import java.lang.String;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class Collection_secure_nft_origynArg0 {
  @Name("0")
  @Field(Type.TEXT)
  public String field0;

  @Name("1")
  @Field(Type.NAT)
  public Optional<BigInteger> field1;

  @Name("2")
  @Field(Type.NAT)
  public Optional<BigInteger> field2;
}
