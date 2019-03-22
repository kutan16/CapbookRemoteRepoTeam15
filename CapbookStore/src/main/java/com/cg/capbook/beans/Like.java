package com.cg.capbook.beans;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
@Entity
public class Like {
	@Id
	String username;
	@ManyToOne
	private Photo photo;
	@ManyToOne
	private Status status;
	public Like() {
		super();
	}
	public Like(String username, Photo photo, Status status) {
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
		return "Like [username=" + username + ", photo=" + photo + ", status=" + status + "]";
	}
	
}
