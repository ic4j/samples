package org.ic4j.origyn.nft;

import java.lang.String;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class EndSaleResponseTxn_typeFieldroyalty_paidValue {
  @Name("tag")
  @Field(Type.TEXT)
  public String tag;

  @Name("token")
  @Field(Type.VARIANT)
  public TokenSpec token;

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

  @Name("receiver")
  @Field(Type.VARIANT)
  public Account receiver;

  @Name("sale_id")
  @Field(Type.TEXT)
  public Optional<String> fieldsale_id;
}
