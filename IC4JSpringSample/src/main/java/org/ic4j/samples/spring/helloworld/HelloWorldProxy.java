package org.ic4j.samples.spring.helloworld;

import java.util.concurrent.CompletableFuture;

import org.ic4j.agent.annotations.Agent;
import org.ic4j.agent.annotations.Argument;
import org.ic4j.agent.annotations.Canister;
import org.ic4j.agent.annotations.Identity;
import org.ic4j.agent.annotations.IdentityType;
import org.ic4j.agent.annotations.Transport;
import org.ic4j.agent.annotations.UPDATE;
import org.ic4j.agent.annotations.Waiter;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

@Agent(identity = @Identity(type = IdentityType.ANONYMOUS), transport = @Transport(url = "https://icp-api.io/"))
@Canister("zrakb-eaaaa-aaaab-qacaq-cai")
public interface HelloWorldProxy {
	
	@UPDATE
	@Name("greet")
	@Waiter(timeout = 30)
	public CompletableFuture<String> greet(@Argument(Type.TEXT)String name);

}
