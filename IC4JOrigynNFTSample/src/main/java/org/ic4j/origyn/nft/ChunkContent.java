package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum ChunkContent {
  remote,

  chunk;

  @Name("remote")
  @Field(Type.RECORD)
  public ChunkContentRemoteValue remoteValue;

  @Name("chunk")
  @Field(Type.RECORD)
  public ChunkContentChunkValue chunkValue;
}
