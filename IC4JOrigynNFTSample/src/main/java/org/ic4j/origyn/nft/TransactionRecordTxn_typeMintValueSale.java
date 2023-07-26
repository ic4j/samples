package org.ic4j.origyn.nft;

import java.lang.Object;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class TransactionRecordTxn_typeMintValueSale {
  @Name("token")
  @Field(Type.RESERVED)
  public Object token;

  @Name("amount")
  @Field(Type.NAT)
  public BigInteger amount;
}
