package org.ic4j.origyn.nft;

import java.lang.String;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class BidRequest {
  @Name("broker_id")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> fieldbroker_id;

  @Name("escrow_receipt")
  @Field(Type.RECORD)
  public EscrowReceipt fieldescrow_receipt;

  @Name("sale_id")
  @Field(Type.TEXT)
  public String fieldsale_id;
}
