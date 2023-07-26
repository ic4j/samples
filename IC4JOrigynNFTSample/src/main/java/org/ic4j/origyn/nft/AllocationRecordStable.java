package org.ic4j.origyn.nft;

import java.lang.String;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class AllocationRecordStable {
  @Name("allocated_space")
  @Field(Type.NAT)
  public BigInteger fieldallocated_space;

  @Name("token_id")
  @Field(Type.TEXT)
  public String fieldtoken_id;

  @Name("available_space")
  @Field(Type.NAT)
  public BigInteger fieldavailable_space;

  @Name("canister")
  @Field(Type.PRINCIPAL)
  public Principal canister;

  @Name("chunks")
  @Field(Type.NAT)
  public BigInteger[] chunks;

  @Name("library_id")
  @Field(Type.TEXT)
  public String fieldlibrary_id;
}
