package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class UserTag {
	@Id
	String emailId;
	@ManyToOne
	UserPhoto userPhoto;
	
	@ManyToOne
	UserStatus userStatus;
	
	public UserTag() {
		super();
	}

}
