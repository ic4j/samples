package org.ic4j.samples.image;

import java.util.concurrent.CompletableFuture;

import org.ic4j.agent.annotations.Argument;
import org.ic4j.agent.annotations.QUERY;
import org.ic4j.agent.annotations.UPDATE;
import org.ic4j.agent.annotations.Waiter;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public interface ImagesProxy {
	
	@QUERY
	@Name("get")
	public byte[] get(@Argument(Type.TEXT)String name );	
	
	@UPDATE
	@Name("add")
	@Waiter(timeout = 30)
	public CompletableFuture<String> add(@Argument(Type.TEXT)String name, @Argument(Type.NAT8)byte[] image);

}
