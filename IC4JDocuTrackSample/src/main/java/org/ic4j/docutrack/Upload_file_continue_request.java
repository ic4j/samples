package org.ic4j.docutrack;

import java.lang.Byte;
import java.lang.Long;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class Upload_file_continue_request {
  @Name("contents")
  @Field(Type.NAT8)
  public Byte[] contents;

  @Name("chunk_id")
  @Field(Type.NAT64)
  public Long fieldchunk_id;

  @Name("file_id")
  @Field(Type.NAT64)
  public Long fieldfile_id;
}
