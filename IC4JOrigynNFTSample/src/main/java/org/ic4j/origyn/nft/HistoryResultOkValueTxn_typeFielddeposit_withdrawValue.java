package org.ic4j.origyn.nft;

import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class HistoryResultOkValueTxn_typeFielddeposit_withdrawValue {
  @Name("fee")
  @Field(Type.NAT)
  public BigInteger fee;

  @Name("token")
  @Field(Type.VARIANT)
  public TokenSpec token;

  @Name("trx_id")
  @Field(Type.VARIANT)
  public DepositDetailTrx_id fieldtrx_id;

  @Name("extensible")
  @Field(Type.VARIANT)
  public CandyShared extensible;

  @Name("buyer")
  @Field(Type.VARIANT)
  public Account buyer;

  @Name("amount")
  @Field(Type.NAT)
  public BigInteger amount;
}
