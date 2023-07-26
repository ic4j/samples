package org.ic4j.origyn.nft;

import java.lang.Object;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class DistributeSaleRequest {
  @Name("seller")
  @Field(Type.RESERVED)
  public Optional<Object> seller;
}
