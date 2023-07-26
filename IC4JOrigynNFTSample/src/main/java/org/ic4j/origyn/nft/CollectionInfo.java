package org.ic4j.origyn.nft;

import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.math.BigInteger;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public class CollectionInfo {
  @Name("multi_canister_count")
  @Field(Type.NAT)
  public Optional<BigInteger> fieldmulti_canister_count;

  @Name("managers")
  @Field(Type.VEC)
  public Optional<Principal[]> managers;

  @Name("owner")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> owner;

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

  @Name("created_at")
  @Field(Type.NAT64)
  public Optional<Long> fieldcreated_at;

  @Name("fields")
  @Field(Type.VEC)
  public Optional<CollectionInfoFields[]> fields;

  @Name("upgraded_at")
  @Field(Type.NAT64)
  public Optional<Long> fieldupgraded_at;

  @Name("token_ids_count")
  @Field(Type.NAT)
  public Optional<BigInteger> fieldtoken_ids_count;

  @Name("available_space")
  @Field(Type.NAT)
  public Optional<BigInteger> fieldavailable_space;

  @Name("multi_canister")
  @Field(Type.VEC)
  public Optional<Principal[]> fieldmulti_canister;

  @Name("token_ids")
  @Field(Type.VEC)
  public Optional<String[]> fieldtoken_ids;

  @Name("transaction_count")
  @Field(Type.NAT)
  public Optional<BigInteger> fieldtransaction_count;

  @Name("unique_holders")
  @Field(Type.NAT)
  public Optional<BigInteger> fieldunique_holders;

  @Name("total_supply")
  @Field(Type.NAT)
  public Optional<BigInteger> fieldtotal_supply;

  @Name("symbol")
  @Field(Type.TEXT)
  public Optional<String> symbol;

  @Name("allocated_storage")
  @Field(Type.NAT)
  public Optional<BigInteger> fieldallocated_storage;
}
