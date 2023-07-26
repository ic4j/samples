package org.ic4j.origyn.nft;

import java.lang.Integer;
import java.lang.String;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class GetLogMessagesFilter {
  @Name("analyzeCount")
  @Field(Type.NAT32)
  public Integer analyzeCount;

  @Name("messageRegex")
  @Field(Type.TEXT)
  public Optional<String> messageRegex;

  @Name("messageContains")
  @Field(Type.TEXT)
  public Optional<String> messageContains;
}
