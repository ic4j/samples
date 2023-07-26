package org.ic4j.origyn.nft;

import java.lang.Byte;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public class Canister_status {
  @Name("status")
  @Field(Type.VARIANT)
  public Canister_statusStatus status;

  @Name("memory_size")
  @Field(Type.NAT)
  public BigInteger fieldmemory_size;

  @Name("cycles")
  @Field(Type.NAT)
  public BigInteger cycles;

  @Name("settings")
  @Field(Type.RECORD)
  public Definite_canister_settings settings;

  @Name("module_hash")
  @Field(Type.VEC)
  public Optional<Byte[]> fieldmodule_hash;
}
