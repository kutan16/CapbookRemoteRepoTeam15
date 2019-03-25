package com.cg.capbook.beans;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Id;
@Embeddable
public class UserData {
	@Id
	private String emailId;
	@Embedded
	private UserAddress address;
	private String education;
	private String relationshipStatus;
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserData(String emailId, UserAddress address, String education, String relationshipStatus) {
		super();
		this.emailId = emailId;
		this.address = address;
		this.education = education;
		this.relationshipStatus = relationshipStatus;
	}
	
}
