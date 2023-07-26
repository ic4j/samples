package org.ic4j.origyn.nft;

import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public enum ManageStorageResponse {
  add_storage_canisters,

  configure_storage;

  @Name("add_storage_canisters")
  @Field(Type.RECORD)
  public ManageStorageResponseFieldadd_storage_canistersValue fieldadd_storage_canistersValue;

  @Name("configure_storage")
  @Field(Type.RECORD)
  public ManageStorageResponseFieldconfigure_storageValue fieldconfigure_storageValue;
}
