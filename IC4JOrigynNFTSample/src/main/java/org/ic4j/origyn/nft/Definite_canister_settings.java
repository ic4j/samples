package org.ic4j.origyn.nft;

import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class Definite_canister_settings {
  @Name("freezing_threshold")
  @Field(Type.NAT)
  public BigInteger fieldfreezing_threshold;

  @Name("controllers")
  @Field(Type.VEC)
  public Optional<Principal[]> controllers;

  @Name("memory_allocation")
  @Field(Type.NAT)
  public BigInteger fieldmemory_allocation;

  @Name("compute_allocation")
  @Field(Type.NAT)
  public BigInteger fieldcompute_allocation;
}
