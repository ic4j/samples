package org.ic4j.origyn.nft;

import java.lang.String;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class NFTInfoStableCurrent_sale {
  @Name("token_id")
  @Field(Type.TEXT)
  public String fieldtoken_id;

  @Name("sale_type")
  @Field(Type.VARIANT)
  public SaleInfoResponseStatusValueSale_type fieldsale_type;

  @Name("broker_id")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> fieldbroker_id;

  @Name("original_broker_id")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> fieldoriginal_broker_id;

  @Name("sale_id")
  @Field(Type.TEXT)
  public String fieldsale_id;
}
