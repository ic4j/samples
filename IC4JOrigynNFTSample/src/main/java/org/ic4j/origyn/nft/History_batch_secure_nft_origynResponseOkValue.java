package org.ic4j.origyn.nft;

import java.lang.String;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class History_batch_secure_nft_origynResponseOkValue {
  @Name("token_id")
  @Field(Type.TEXT)
  public String fieldtoken_id;

  @Name("txn_type")
  @Field(Type.VARIANT)
  public HistoryResultOkValueTxn_type fieldtxn_type;

  @Name("timestamp")
  @Field(Type.INT)
  public BigInteger timestamp;

  @Name("index")
  @Field(Type.NAT)
  public BigInteger index;
}
