package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum ManageStorageRequest {
  add_storage_canisters,

  configure_storage;

  @Name("add_storage_canisters")
  @Field(Type.RECORD)
  public ManageStorageRequestFieldadd_storage_canistersValue[] fieldadd_storage_canistersValue;

  @Name("configure_storage")
  @Field(Type.VARIANT)
  public ManageStorageRequestFieldconfigure_storageValue fieldconfigure_storageValue;
}
