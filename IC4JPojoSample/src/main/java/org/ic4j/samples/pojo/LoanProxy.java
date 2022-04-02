package org.ic4j.samples.pojo;

import java.util.concurrent.CompletableFuture;

import org.ic4j.agent.annotations.Waiter;
import org.ic4j.agent.annotations.UPDATE;
import org.ic4j.agent.annotations.Argument;
import org.ic4j.agent.annotations.QUERY;
import org.ic4j.agent.annotations.ResponseClass;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;

public interface LoanProxy {
	
	@UPDATE
	@Name("apply")
	@Waiter(timeout = 30)
	@ResponseClass(LoanOffer.class)
	public CompletableFuture<LoanOffer> apply(@Argument(Type.RECORD) LoanApplication loanApplication);
	
	@QUERY
	@Name("getOffers")
	public LoanOffer[] getOffers();

}
