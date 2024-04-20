package org.ic4j.docutrack;

import java.lang.Byte;
import java.lang.Long;
import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class Found_file {
  @Name("contents")
  @Field(Type.NAT8)
  public Byte[] contents;

  @Name("owner_key")
  @Field(Type.NAT8)
  public Byte[] fieldowner_key;

  @Name("file_type")
  @Field(Type.TEXT)
  public String fieldfile_type;

  @Name("num_chunks")
  @Field(Type.NAT64)
  public Long fieldnum_chunks;
}
