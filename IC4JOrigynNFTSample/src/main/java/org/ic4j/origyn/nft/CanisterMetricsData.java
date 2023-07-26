package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum CanisterMetricsData {
  hourly,

  daily;

  @Name("hourly")
  @Field(Type.RECORD)
  public HourlyMetricsData[] hourlyValue;

  @Name("daily")
  @Field(Type.RECORD)
  public DailyMetricsData[] dailyValue;
}
