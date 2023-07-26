package org.ic4j.origyn.nft;

import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum ManageStorageRequestFieldconfigure_storageValue {
  stableBtree,

  heap;

  @Name("stableBtree")
  @Field(Type.NAT)
  public Optional<BigInteger> stableBtreeValue;

  @Name("heap")
  @Field(Type.NAT)
  public Optional<BigInteger> heapValue;
}
