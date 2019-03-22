package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Tag {
	@Id
	String username;
	@ManyToOne
	private Photo photo;
	
	@ManyToOne
	private Status status;

	public Tag() {
		super();
	}

	public Tag(String username, Photo photo, Status status) {
		super();
		this.username = username;
		this.photo = photo;
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Tag [username=" + username + ", photo=" + photo + ", status=" + status + "]";
	}
	
}
