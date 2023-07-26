package org.ic4j.origyn.nft;

import java.lang.String;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class HistoryResultOkValueTxn_typeFieldauction_bidValue {
  @Name("token")
  @Field(Type.VARIANT)
  public TokenSpec token;

  @Name("extensible")
  @Field(Type.VARIANT)
  public CandyShared extensible;

  @Name("buyer")
  @Field(Type.VARIANT)
  public Account buyer;

  @Name("amount")
  @Field(Type.NAT)
  public BigInteger amount;

  @Name("sale_id")
  @Field(Type.TEXT)
  public String fieldsale_id;
}
