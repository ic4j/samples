package org.ic4j.origyn.nft;

import java.lang.String;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class TransactionRecordTxn_typeFieldescrow_depositValue {
  @Name("token")
  @Field(Type.VARIANT)
  public TokenSpec token;

  @Name("token_id")
  @Field(Type.TEXT)
  public String fieldtoken_id;

  @Name("trx_id")
  @Field(Type.VARIANT)
  public TransactionID fieldtrx_id;

  @Name("seller")
  @Field(Type.VARIANT)
  public Account seller;

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
