package org.ic4j.origyn.nft;

import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class EscrowResponse {
  @Name("balance")
  @Field(Type.NAT)
  public BigInteger balance;

  @Name("receipt")
  @Field(Type.RECORD)
  public EscrowReceipt receipt;

  @Name("transaction")
  @Field(Type.RECORD)
  public TransactionRecord transaction;
}
