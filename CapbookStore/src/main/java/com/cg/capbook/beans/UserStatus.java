package com.cg.capbook.beans;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class UserStatus {
	@Id
	int Id;
	String status;
	LocalDate dateOfPost;
	@ManyToOne
	 UserAccount userAccount;
	
//	@OneToMany(mappedBy="userStatus")
//	private List<UserLike> userLike;
	
	@OneToMany(mappedBy="userStatus")
	private List<UserPostComment> userComment;
	
	@OneToMany(mappedBy="userStatus")
	private List<UserTag> userTag;
	
	public UserStatus() {
		super();
	}

	public UserStatus(int id, String status, LocalDate dateOfPost, UserAccount userAccount,
			List<UserPostComment> userComment, List<UserTag> userTag) {
		super();
		Id = id;
		this.status = status;
		this.dateOfPost = dateOfPost;
		this.userAccount = userAccount;
		this.userComment = userComment;
		this.userTag = userTag;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDateOfPost() {
		return dateOfPost;
	}

	public void setDateOfPost(LocalDate dateOfPost) {
		this.dateOfPost = dateOfPost;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public List<UserPostComment> getUserComment() {
		return userComment;
	}

	public void setUserComment(List<UserPostComment> userComment) {
		this.userComment = userComment;
	}

	public List<UserTag> getUserTag() {
		return userTag;
	}

	public void setUserTag(List<UserTag> userTag) {
		this.userTag = userTag;
	}

}
