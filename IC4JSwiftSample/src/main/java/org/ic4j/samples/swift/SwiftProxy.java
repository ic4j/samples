package org.ic4j.samples.swift;

import java.util.concurrent.CompletableFuture;

import org.ic4j.agent.annotations.Waiter;
import org.ic4j.agent.annotations.UPDATE;
import org.ic4j.agent.annotations.Argument;
import org.ic4j.candid.annotations.Deserializer;
import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.annotations.Serializer;
import org.ic4j.candid.jaxb.JAXBSerializer;
import org.ic4j.candid.jaxb.JAXBDeserializer;
import org.ic4j.candid.types.Type;

import com.prowidesoftware.swift.model.mx.dic.FIToFICustomerCreditTransferV07;
import com.prowidesoftware.swift.model.mx.dic.FinancialInstitutionCreditTransferV09;

public interface SwiftProxy {
	
	@UPDATE
	@Name("reversalRequest")
	@Deserializer(JAXBDeserializer.class)
	@Waiter(timeout = 30)
	public CompletableFuture<FIToFICustomerCreditTransferV07> reversalRequest(@Serializer(JAXBSerializer.class) @Argument(Type.RECORD)FIToFICustomerCreditTransferV07 request);

	
	@UPDATE
	@Name("creditTransfer")
	@Deserializer(JAXBDeserializer.class)
	@Waiter(timeout = 30)
	public CompletableFuture<FinancialInstitutionCreditTransferV09> creditTransfer(@Serializer(JAXBSerializer.class) @Argument(Type.RECORD)FinancialInstitutionCreditTransferV09 credit);
	
	
}
