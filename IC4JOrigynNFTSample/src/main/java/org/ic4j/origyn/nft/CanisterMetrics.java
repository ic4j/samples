package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class CanisterMetrics {
  @Name("data")
  @Field(Type.VARIANT)
  public CanisterMetricsData data;
}
