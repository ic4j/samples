package org.ic4j.samples.ws;

import java.util.concurrent.CompletableFuture;

import org.ic4j.agent.annotations.QUERY;
import org.ic4j.agent.annotations.UPDATE;

public interface HelloProxy {
	
	@QUERY
	public String peek();
	
	@UPDATE
	public CompletableFuture<String> greet(String name);
}
