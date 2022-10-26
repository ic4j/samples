package org.ic4j.samples.jaxb;


import java.math.BigInteger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "data", namespace="http://ic4j.org/samples")
public class LoanApplication{
	@XmlElement(name="id", namespace="http://ic4j.org/samples", required=true)
    public BigInteger id;
	@XmlElement(name="amount", namespace="http://ic4j.org/samples", required=true)
	public Double amount;
	@XmlElement(name="term", namespace="http://ic4j.org/samples", required=true)   
    public Short term;
	@XmlElement(name="firstname", namespace="http://ic4j.org/samples", required=true)
    public String firstName;
	@XmlElement(name="lastname", namespace="http://ic4j.org/samples", required=true)
    public String lastName;
	@XmlElement(name="ssn", namespace="http://ic4j.org/samples", required=true)
    public String ssn;
	@XmlElement(name="zipcode", namespace="http://ic4j.org/samples", required=true)
    public String zipcode;
	@XmlElement(name="created", namespace="http://ic4j.org/samples", required=true)
    public BigInteger created;

    
    // only for testing purposes
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		result = prime * result + ((term == null) ? 0 : term.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
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
		LoanApplication other = (LoanApplication) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		if (term == null) {
			if (other.term != null)
				return false;
		} else if (!term.equals(other.term))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	} 
}
