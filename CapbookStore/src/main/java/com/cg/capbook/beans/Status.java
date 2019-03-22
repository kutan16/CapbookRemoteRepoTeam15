package com.cg.capbook.beans;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
@Entity
public class Status {
	@Id
	String statusId;
	String status;
	@ManyToOne
	private UserAccount userAccount;
	
	@OneToMany(mappedBy="like", cascade=CascadeType.ALL)
	@MapKey
	private Map<Integer, Like> like;
	
	@OneToMany(mappedBy="comment", cascade=CascadeType.ALL)
	@MapKey
	private Map<Integer, Comment> comment;
	
	@OneToMany(mappedBy="tag", cascade=CascadeType.ALL)
	@MapKey
	private Map<Integer, Tag> tag;

	public Status() {
		super();
	}

	public Status(String statusId, String status, UserAccount userAccount, Map<Integer, Like> like,
			Map<Integer, Comment> comment, Map<Integer, Tag> tag) {
		super();
		this.statusId = statusId;
		this.status = status;
		this.userAccount = userAccount;
		this.like = like;
		this.comment = comment;
		this.tag = tag;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public Map<Integer, Like> getLike() {
		return like;
	}

	public void setLike(Map<Integer, Like> like) {
		this.like = like;
	}

	public Map<Integer, Comment> getComment() {
		return comment;
	}

	public void setComment(Map<Integer, Comment> comment) {
		this.comment = comment;
	}

	public Map<Integer, Tag> getTag() {
		return tag;
	}

	public void setTag(Map<Integer, Tag> tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", status=" + status + ", userAccount=" + userAccount + ", like=" + like
				+ ", comment=" + comment + ", tag=" + tag + "]";
	}
	
}
