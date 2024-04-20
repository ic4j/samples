package org.ic4j.docutrack;

import java.lang.Byte;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class File {
  @Name("contents")
  @Field(Type.VEC)
  public Optional<Byte[]> contents;

  @Name("metadata")
  @Field(Type.RECORD)
  public File_metadata metadata;
}
