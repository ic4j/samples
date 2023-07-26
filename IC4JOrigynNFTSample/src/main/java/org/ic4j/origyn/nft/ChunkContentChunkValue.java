package org.ic4j.origyn.nft;

import java.lang.Byte;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class ChunkContentChunkValue {
  @Name("total_chunks")
  @Field(Type.NAT)
  public BigInteger fieldtotal_chunks;

  @Name("content")
  @Field(Type.NAT8)
  public Byte[] content;

  @Name("storage_allocation")
  @Field(Type.RECORD)
  public AllocationRecordStable fieldstorage_allocation;

  @Name("current_chunk")
  @Field(Type.NAT)
  public Optional<BigInteger> fieldcurrent_chunk;
}
