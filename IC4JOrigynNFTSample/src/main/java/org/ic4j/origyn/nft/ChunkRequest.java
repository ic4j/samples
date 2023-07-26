package org.ic4j.origyn.nft;

import java.lang.String;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class ChunkRequest {
  @Name("token_id")
  @Field(Type.TEXT)
  public String fieldtoken_id;

  @Name("chunk")
  @Field(Type.NAT)
  public Optional<BigInteger> chunk;

  @Name("library_id")
  @Field(Type.TEXT)
  public String fieldlibrary_id;
}
