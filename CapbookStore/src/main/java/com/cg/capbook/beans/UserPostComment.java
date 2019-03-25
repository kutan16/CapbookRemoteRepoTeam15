package com.cg.capbook.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class UserPostComment {
	@Id
	String emailId;
	String userComment;
	LocalDate dateOfPost;
	@ManyToOne
	private UserPhoto userPhoto;
	
	@ManyToOne
	private UserStatus userStatus;

	public UserPostComment() {
		super();
	}
}
