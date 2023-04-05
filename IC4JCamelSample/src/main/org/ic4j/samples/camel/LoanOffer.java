package org.ic4j.samples.camel;

import org.ic4j.candid.annotations.Name;
import org.ic4j.candid.types.Type;
import org.ic4j.types.Principal;
import org.ic4j.types.PrincipalDeserializer;
import org.ic4j.types.PrincipalSerializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.ic4j.candid.annotations.Field;

public class LoanOffer{
	@JsonProperty("providerid")
    @Field(Type.PRINCIPAL)
    @Name("providerid")
    public String providerId;	
	@JsonProperty("providername")
    @Name("providername")
    public String providerName; 
	@JsonProperty("userid")
	@JsonSerialize(using = PrincipalSerializer.class)
	@JsonDeserialize(using = PrincipalDeserializer.class)
    @Field(Type.PRINCIPAL)
    @Name("userid")
    public Principal userId;
	@JsonProperty("applicationid")
    @Field(Type.NAT)
    @Name("applicationid")
    public Integer applicationId;
    public Double apr;
    @Field(Type.INT)
    public Long created;
    
    
    
    /**
	 * @return the providerId
	 */
	public String getProviderId() {
		return providerId;
	}
	/**
	 * @return the providerName
	 */
	public String getProviderName() {
		return providerName;
	}
	/**
	 * @return the userId
	 */
	public Principal getUserId() {
		return userId;
	}
	/**
	 * @return the applicationId
	 */
	public Integer getApplicationId() {
		return applicationId;
	}
	/**
	 * @return the apr
	 */
	public Double getApr() {
		return apr;
	}
	/**
	 * @return the created
	 */
	public Long getCreated() {
		return created;
	}
	// only for testing purposes
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicationId == null) ? 0 : applicationId.hashCode());
		result = prime * result + ((apr == null) ? 0 : apr.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((providerId == null) ? 0 : providerId.hashCode());
		result = prime * result + ((providerName == null) ? 0 : providerName.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanOffer other = (LoanOffer) obj;
		if (applicationId == null) {
			if (other.applicationId != null)
				return false;
		} else if (!applicationId.equals(other.applicationId))
			return false;
		if (apr == null) {
			if (other.apr != null)
				return false;
		} else if (!apr.equals(other.apr))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (providerId == null) {
			if (other.providerId != null)
				return false;
		} else if (!providerId.equals(other.providerId))
			return false;
		if (providerName == null) {
			if (other.providerName != null)
				return false;
		} else if (!providerName.equals(other.providerName))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
    
    
}
