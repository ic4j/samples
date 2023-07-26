package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class ChunkContentRemoteValue {
  @Name("args")
  @Field(Type.RECORD)
  public ChunkRequest args;

  @Name("canister")
  @Field(Type.PRINCIPAL)
  public Principal canister;
}
