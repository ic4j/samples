package org.ic4j.docutrack;

import java.lang.Byte;
import java.lang.Long;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class File_statusUploadedValue {
  @Name("document_key")
  @Field(Type.NAT8)
  public Byte[] fielddocument_key;

  @Name("uploaded_at")
  @Field(Type.NAT64)
  public Long fielduploaded_at;
}
