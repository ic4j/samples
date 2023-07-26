package org.ic4j.origyn.nft;

import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class ManageStorageRequestFieldadd_storage_canistersValue {
  @Name("0")
  @Field(Type.PRINCIPAL)
  public Principal field0;

  @Name("1")
  @Field(Type.NAT)
  public BigInteger field1;

  @Name("2")
  @Field(Type.RECORD)
  public ManageStorageRequestFieldadd_storage_canistersValue2 field2;
}
