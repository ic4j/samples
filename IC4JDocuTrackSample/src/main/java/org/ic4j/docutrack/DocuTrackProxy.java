package org.ic4j.docutrack;

import java.lang.Boolean;
import java.lang.Byte;
import java.lang.Long;
import java.lang.String;
import java.lang.Void;
import java.util.concurrent.CompletableFuture;
import org.ic4j.agent.annotations.Agent;
import org.ic4j.agent.annotations.Argument;
import org.ic4j.agent.annotations.Canister;
import org.ic4j.agent.annotations.EffectiveCanister;
import org.ic4j.agent.annotations.Identity;
import org.ic4j.agent.annotations.IdentityType;
import org.ic4j.agent.annotations.Transport;
import org.ic4j.candid.annotations.Modes;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Mode;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;

@Agent(
    transport = @Transport(url = "https://icp-api.io/"),
    identity = @Identity(type = IdentityType.BASIC)
)

public interface DocuTrackProxy {
  @Name("get_requests")
  @Modes(Mode.QUERY)
  File_metadata[] get_requests();

  @Name("set_user")
  CompletableFuture<Set_user_response> set_user(@Argument(Type.TEXT) String arg0,
      @Argument(Type.NAT8) Byte[] arg1);

  @Name("get_users")
  @Modes(Mode.QUERY)
  Get_users_response get_users();

  @Name("request_file")
  CompletableFuture<String> request_file(@Argument(Type.TEXT) String arg0);

  @Name("download_file")
  @Modes(Mode.QUERY)
  Download_file_response download_file(@Argument(Type.NAT64) Long arg0,
      @Argument(Type.NAT64) Long arg1);

  @Name("upload_file")
  CompletableFuture<Upload_file_response> upload_file(
      @Argument(Type.RECORD) Upload_file_request arg0);

  @Name("who_am_i")
  @Modes(Mode.QUERY)
  Who_am_i_response who_am_i();

  @Name("get_shared_files")
  @Modes(Mode.QUERY)
  File_metadata[] get_shared_files();

  @Name("hello_world")
  CompletableFuture<String> hello_world();

  @Name("upload_file_continue")
  CompletableFuture<Void> upload_file_continue(
      @Argument(Type.RECORD) Upload_file_continue_request arg0);

  @Name("revoke_share")
  CompletableFuture<Share_file_response> revoke_share(@Argument(Type.PRINCIPAL) Principal arg0,
      @Argument(Type.NAT64) Long arg1);

  @Name("get_alias_info")
  @Modes(Mode.QUERY)
  Get_alias_info_response get_alias_info(@Argument(Type.TEXT) String arg0);

  @Name("share_file_with_users")
  CompletableFuture<Void> share_file_with_users(@Argument(Type.PRINCIPAL) Principal[] arg0,
      @Argument(Type.NAT64) Long arg1, @Argument(Type.VEC) Byte[][] arg2);

  @Name("username_exists")
  @Modes(Mode.QUERY)
  Boolean username_exists(@Argument(Type.TEXT) String arg0);

  @Name("share_file")
  CompletableFuture<Share_file_response> share_file(@Argument(Type.PRINCIPAL) Principal arg0,
      @Argument(Type.NAT64) Long arg1, @Argument(Type.NAT8) Byte[] arg2);

  @Name("upload_file_atomic")
  CompletableFuture<Long> upload_file_atomic(
      @Argument(Type.RECORD) Upload_file_atomic_request arg0);
}
