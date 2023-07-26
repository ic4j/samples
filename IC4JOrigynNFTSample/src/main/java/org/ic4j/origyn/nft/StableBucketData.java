package org.ic4j.origyn.nft;

import java.lang.Boolean;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class StableBucketData {
  @Name("principal")
  @Field(Type.PRINCIPAL)
  public Principal principal;

  @Name("allocated_space")
  @Field(Type.NAT)
  public BigInteger fieldallocated_space;

  @Name("date_added")
  @Field(Type.INT)
  public BigInteger fielddate_added;

  @Name("version")
  @Field(Type.RECORD)
  public StableBucketDataVersion version;

  @Name("b_gateway")
  @Field(Type.BOOL)
  public Boolean fieldb_gateway;

  @Name("available_space")
  @Field(Type.NAT)
  public BigInteger fieldavailable_space;

  @Name("allocations")
  @Field(Type.RECORD)
  public StableBucketDataAllocations[] allocations;
}
