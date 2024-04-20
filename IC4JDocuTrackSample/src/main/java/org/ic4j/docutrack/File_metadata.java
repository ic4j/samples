package org.ic4j.docutrack;

import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class File_metadata {
  @Name("file_status")
  @Field(Type.VARIANT)
  public File_status fieldfile_status;

  @Name("file_name")
  @Field(Type.TEXT)
  public String fieldfile_name;

  @Name("shared_with")
  @Field(Type.RESERVED)
  public Object[] fieldshared_with;

  @Name("file_id")
  @Field(Type.NAT64)
  public Long fieldfile_id;
}
