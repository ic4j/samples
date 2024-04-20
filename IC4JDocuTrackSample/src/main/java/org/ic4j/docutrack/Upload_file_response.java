package org.ic4j.docutrack;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum Upload_file_response {
  Ok,

  Err;

  @Name("Err")
  @Field(Type.VARIANT)
  public Upload_file_error errValue;
}
