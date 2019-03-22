package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class UserComment {
	@Id
	String commentId;
	String comment;
	@ManyToOne
	private UserPhoto pphoto;
	@ManyToOne
	private UserStatus sstatus;
	@ManyToOne
	UserAccount userAccount;
	public UserComment() {
		super();
	}
	public UserComment(String commentId, String comment, UserPhoto photo, UserStatus status, UserAccount userAccount) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.pphoto = photo;
		this.sstatus = status;
		this.userAccount = userAccount;
	}
	public String getCommentId() {
		return commentId;
	}
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public UserAccount getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", photo=" + pphoto + ", status=" + sstatus
				+ ", userAccount=" + userAccount + "]";
	}
	
}
