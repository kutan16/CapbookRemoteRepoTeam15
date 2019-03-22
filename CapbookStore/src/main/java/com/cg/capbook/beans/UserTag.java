package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class UserTag {
	@Id
	String username;
	@ManyToOne
	private UserPhoto pphoto;
	
	@ManyToOne
	private UserStatus sstatus;

	public UserTag() {
		super();
	}

	public UserTag(String username, UserPhoto photo, UserStatus status) {
		super();
		this.username = username;
		this.pphoto = photo;
		this.sstatus = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public UserPhoto getPhoto() {
		return pphoto;
	}

	public void setPhoto(UserPhoto photo) {
		this.pphoto = photo;
	}

	public UserStatus getStatus() {
		return sstatus;
	}

	public void setStatus(UserStatus status) {
		this.sstatus = status;
	}

	@Override
	public String toString() {
		return "Tag [username=" + username + ", photo=" + pphoto + ", status=" + sstatus + "]";
	}
	
}
