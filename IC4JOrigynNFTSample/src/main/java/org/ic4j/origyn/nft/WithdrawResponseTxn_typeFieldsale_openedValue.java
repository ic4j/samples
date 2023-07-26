package org.ic4j.origyn.nft;

import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class WithdrawResponseTxn_typeFieldsale_openedValue {
  @Name("pricing")
  @Field(Type.VARIANT)
  public PricingConfig pricing;

  @Name("extensible")
  @Field(Type.VARIANT)
  public CandyShared extensible;

  @Name("sale_id")
  @Field(Type.TEXT)
  public String fieldsale_id;
}
