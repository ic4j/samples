package org.ic4j.origyn.nft;

import java.lang.String;
import java.util.Optional;
import org.ic4j.candid.annotations.Field;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

public enum ManageCollectionCommand {
  UpdateOwner,

  UpdateManagers,

  UpdateMetadata,

  UpdateAnnounceCanister,

  UpdateNetwork,

  UpdateSymbol,

  UpdateLogo,

  UpdateName;

  @Name("UpdateOwner")
  @Field(Type.PRINCIPAL)
  public Principal updateOwnerValue;

  @Name("UpdateManagers")
  @Field(Type.PRINCIPAL)
  public Principal[] updateManagersValue;

  @Name("UpdateMetadata")
  @Field(Type.RECORD)
  public ManageCollectionCommandUpdateMetadataValue updateMetadataValue;

  @Name("UpdateAnnounceCanister")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> updateAnnounceCanisterValue;

  @Name("UpdateNetwork")
  @Field(Type.PRINCIPAL)
  public Optional<Principal> updateNetworkValue;

  @Name("UpdateSymbol")
  @Field(Type.TEXT)
  public Optional<String> updateSymbolValue;

  @Name("UpdateLogo")
  @Field(Type.TEXT)
  public Optional<String> updateLogoValue;

  @Name("UpdateName")
  @Field(Type.TEXT)
  public Optional<String> updateNameValue;
}
