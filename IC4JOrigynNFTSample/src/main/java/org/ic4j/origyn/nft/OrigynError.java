package org.ic4j.origyn.nft;

import java.lang.Integer;
import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class OrigynError {
  @Name("text")
  @Field(Type.TEXT)
  public String text;

  @Name("error")
  @Field(Type.VARIANT)
  public Errors error;

  @Name("number")
  @Field(Type.NAT32)
  public Integer number;

  @Name("flag_point")
  @Field(Type.TEXT)
  public String fieldflag_point;
}
