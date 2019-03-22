package com.cg.capbook.beans;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Id;
@Embeddable
public class UserData {

	private String education;
	private String relationshipStatus;
	@Embedded
	private UserAddress address;
	public UserData() {
		super();
	}
	public UserData(String education, String relationshipStatus, UserAddress address) {
		super();
		this.education = education;
		this.relationshipStatus = relationshipStatus;
		this.address = address;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getRelationshipStatus() {
		return relationshipStatus;
	}
	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}
	public UserAddress getAddress() {
		return address;
	}
	public void setAddress(UserAddress address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Data [education=" + education + ", relationshipStatus=" + relationshipStatus + ", address=" + address
				+ "]";
	}
	
}
