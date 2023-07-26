package org.ic4j.origyn.nft;

import java.lang.Object;
import java.lang.String;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class StableCollectionData {
  @Name("active_bucket")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> fieldactive_bucket;

  @Name("managers")
  @Field(Type.PRINCIPAL)
  public Principal[] managers;

  @Name("owner")
  @Field(Type.PRINCIPAL)
  public Principal owner;

  @Name("metadata")
  @Field(Type.RESERVED)
  public Optional<Object> metadata;

  @Name("logo")
  @Field(Type.TEXT)
  public Optional<String> logo;

  @Name("name")
  @Field(Type.TEXT)
  public Optional<String> name;

  @Name("network")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> network;

  @Name("available_space")
  @Field(Type.NAT)
  public BigInteger fieldavailable_space;

  @Name("symbol")
  @Field(Type.TEXT)
  public Optional<String> symbol;

  @Name("allocated_storage")
  @Field(Type.NAT)
  public BigInteger fieldallocated_storage;
}
