package org.ic4j.origyn.nft;

import java.lang.Object;
import java.math.BigInteger;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class StorageMetrics {
  @Name("gateway")
  @Field(Type.PRINCIPAL)
  public Principal gateway;

  @Name("available_space")
  @Field(Type.NAT)
  public BigInteger fieldavailable_space;

  @Name("allocations")
  @Field(Type.RESERVED)
  public Object[] allocations;

  @Name("allocated_storage")
  @Field(Type.NAT)
  public BigInteger fieldallocated_storage;
}
