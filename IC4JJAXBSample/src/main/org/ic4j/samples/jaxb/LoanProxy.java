package org.ic4j.samples.jaxb;

import java.util.concurrent.CompletableFuture;

import org.ic4j.agent.annotations.Waiter;
import org.ic4j.agent.annotations.UPDATE;
import org.ic4j.agent.annotations.Argument;
import org.ic4j.agent.annotations.QUERY;
import org.ic4j.candid.annotations.Deserializer;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.annotations.Serializer;
import org.ic4j.candid.jaxb.JAXBDeserializer;
import org.ic4j.candid.jaxb.JAXBSerializer;
import org.ic4j.candid.types.Type;

public interface LoanProxy {
	
	@UPDATE
	@Name("apply")
	@Deserializer(JAXBDeserializer.class)
	@Waiter(timeout = 30)
	public CompletableFuture<LoanOffer> apply(@Serializer(JAXBSerializer.class) @Argument(Type.RECORD) LoanApplication loanApplication);	
}
