package org.ic4j.docutrack;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum Download_file_response {
  found_file,

  permission_error,

  not_uploaded_file,

  not_found_file;

  @Name("found_file")
  @Field(Type.RECORD)
  public Found_file fieldfound_fileValue;
}
