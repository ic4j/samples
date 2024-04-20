package org.ic4j.docutrack;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum File_status {
  partially_uploaded,

  pending,

  uploaded;

  @Name("pending")
  @Field(Type.RECORD)
  public File_statusPendingValue pendingValue;

  @Name("uploaded")
  @Field(Type.RECORD)
  public File_statusUploadedValue uploadedValue;
}
