package org.ic4j.samples.jaxb;

import org.ic4j.types.Principal;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "data", namespace="http://ic4j.org/samples")
public class LoanOffer{
	@XmlElement(name="providerid", namespace="http://ic4j.org/samples", required=true)
    public String providerId;	
	@XmlElement(name="providername", namespace="http://ic4j.org/samples", required=true)
    public String providerName;    
	@XmlElement(name="userid", namespace="http://ic4j.org/samples", required=true)
    public Principal userId;
	@XmlElement(name="applicationid", namespace="http://ic4j.org/samples", required=true)
    public Integer applicationId;
	@XmlElement(name="apr", namespace="http://ic4j.org/samples", required=true)
    public Double apr;
	@XmlElement(name="created", namespace="http://ic4j.org/samples", required=true)
    public Long created;
    
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
