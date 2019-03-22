package com.cg.capbook.beans;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
@Entity
public class UserStatus {
	@Id
	String statusId;
	String status;
	@ManyToOne
	private UserAccount userAccount;
	
	@OneToMany(mappedBy="sstatus", cascade=CascadeType.ALL)
	@MapKey
	private List<UserLike> llike;
	
	@OneToMany(mappedBy="sstatus", cascade=CascadeType.ALL)
	@MapKey
	private List<UserComment> ccomment;
	
	@OneToMany(mappedBy="sstatus", cascade=CascadeType.ALL)
	@MapKey
	private List<UserTag> ttag;

	public UserStatus() {
		super();
	}

	public UserStatus(String statusId, String status, UserAccount userAccount, List<UserLike> like, List<UserComment> comment,
			List<UserTag> tag) {
		super();
		this.statusId = statusId;
		this.status = status;
		this.userAccount = userAccount;
		this.llike = like;
		this.ccomment = comment;
		this.ttag = tag;
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
	
	public List<UserLike> getLike() {
		return llike;
	}

	public void setLike(List<UserLike> like) {
		this.llike = like;
	}

	public List<UserComment> getComment() {
		return ccomment;
	}

	public void setComment(List<UserComment> comment) {
		this.ccomment = comment;
	}

	public List<UserTag> getTag() {
		return ttag;
	}

	public void setTag(List<UserTag> tag) {
		this.ttag = tag;
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", status=" + status + ", userAccount=" + userAccount + ", like=" + llike
				+ ", comment=" + ccomment + ", tag=" + ttag + "]";
	}
	
}
