package org.ic4j.origyn.nft;

import java.lang.String;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum TransactionID {
  nat,

  text,

  extensible;

  @Name("nat")
  @Field(Type.NAT)
  public BigInteger natValue;

  @Name("text")
  @Field(Type.TEXT)
  public String textValue;

  @Name("extensible")
  @Field(Type.VARIANT)
  public CandyShared extensibleValue;
}
