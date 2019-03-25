package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserFriendRequest {
	@Id
	String emailId;
	String username;
	@ManyToOne
	UserAccount userAccount;
}
