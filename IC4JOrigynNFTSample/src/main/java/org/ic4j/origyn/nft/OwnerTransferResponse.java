package org.ic4j.origyn.nft;

import java.lang.Object;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class OwnerTransferResponse {
  @Name("transaction")
  @Field(Type.RECORD)
  public TransactionRecord transaction;

  @Name("assets")
  @Field(Type.RESERVED)
  public Object[] assets;
}
