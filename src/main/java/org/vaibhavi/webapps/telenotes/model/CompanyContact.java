package org.vaibhavi.webapps.telenotes.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class CompanyContact {
	
	
	@Id
	private String companyName;
	
	private String contactName;
	
	private String phoneNumber;
	
	public CompanyContact() {
		super();
	}
	
	public CompanyContact(String companyName) {
		super();;
		this.companyName = companyName;
		this.contactName = "unknown";
		this.phoneNumber = "missing";
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
