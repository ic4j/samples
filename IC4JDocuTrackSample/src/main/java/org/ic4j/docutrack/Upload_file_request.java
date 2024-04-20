package org.ic4j.docutrack;

import java.lang.Byte;
import java.lang.Long;
import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class Upload_file_request {
  @Name("owner_key")
  @Field(Type.NAT8)
  public Byte[] fieldowner_key;

  @Name("file_type")
  @Field(Type.TEXT)
  public String fieldfile_type;

  @Name("num_chunks")
  @Field(Type.NAT64)
  public Long fieldnum_chunks;

  @Name("file_content")
  @Field(Type.NAT8)
  public Byte[] fieldfile_content;

  @Name("file_id")
  @Field(Type.NAT64)
  public Long fieldfile_id;
}
