package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class Comment {
	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	String commentId;
	String comment;
	@ManyToOne
	private Photo photo;
	@ManyToOne
	private Status status;
	@ManyToOne
	UserAccount userAccount;
	public Comment() {
		super();
	}
	public Comment(String commentId, String comment, Photo photo, Status status, UserAccount userAccount) {
		super();
		this.commentId = commentId;
		this.comment = comment;
		this.photo = photo;
		this.status = status;
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
	public UserAccount getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + ", photo=" + photo + ", status=" + status
				+ ", userAccount=" + userAccount + "]";
	}
	
}
