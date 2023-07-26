package org.ic4j.origyn.nft;

import java.lang.String;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class TransactionRecord {
  @Name("token_id")
  @Field(Type.TEXT)
  public String fieldtoken_id;

  @Name("txn_type")
  @Field(Type.VARIANT)
  public TransactionRecordTxn_type fieldtxn_type;

  @Name("timestamp")
  @Field(Type.INT)
  public BigInteger timestamp;

  @Name("index")
  @Field(Type.NAT)
  public BigInteger index;
}
