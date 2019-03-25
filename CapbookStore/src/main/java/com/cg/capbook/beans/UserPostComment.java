package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class UserPostComment {
	@Id
	String emailId;
	String userComment;
	@ManyToOne
	private UserPhoto userPhoto;
	
	@ManyToOne
	private UserStatus userStatus;

	public UserPostComment() {
		super();
	}
}
