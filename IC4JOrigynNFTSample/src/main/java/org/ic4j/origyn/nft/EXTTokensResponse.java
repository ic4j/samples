package org.ic4j.origyn.nft;

import java.lang.Byte;
import java.lang.Integer;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class EXTTokensResponse {
  @Name("0")
  @Field(Type.NAT32)
  public Integer field0;

  @Name("1")
  @Field(Type.RECORD)
  public Optional<EXTTokensResponse1> field1;

  @Name("2")
  @Field(Type.VEC)
  public Optional<Byte[]> field2;
}
