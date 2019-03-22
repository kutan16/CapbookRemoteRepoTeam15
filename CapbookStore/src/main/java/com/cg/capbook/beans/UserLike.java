package com.cg.capbook.beans;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
@Entity
public class UserLike {
	@Id
	String likeId;
	@ManyToOne
	private UserPhoto pphoto;
	@ManyToOne
	private UserStatus sstatus;
	public UserLike() {
		super();
	}
	public UserLike(String likeId, UserPhoto photo, UserStatus status) {
		super();
		this.likeId = likeId;
		this.pphoto = photo;
		this.sstatus = status;
	}
	public String getLikeId() {
		return likeId;
	}
	public void setLikeId(String likeId) {
		this.likeId = likeId;
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
		return "Like [likeId=" + likeId + ", photo=" + pphoto + ", status=" + sstatus + "]";
	}
	
}
