 package com.cg.capbook.beans;
 import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserFriend {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int friendId;
	private String friendEmailId;
	@ManyToOne
	private UserAccount account;
	public UserFriend () {}
	public String getFriendEmailId() {
		return friendEmailId;
	}
	public void setFriendEmailId(String friendEmailId) {
		this.friendEmailId = friendEmailId;
	}
	public UserAccount getAccount() {
		return account;
	}
	public void setAccount(UserAccount account) {
		this.account = account;
	}
	public UserFriend(String friendEmailId, UserAccount account) {
		super();
		this.friendEmailId = friendEmailId;
		this.account = account;
	}
	@Override
	public String toString() {
		return "Friend [friendId=" + friendId + ", friendEmailId=" + friendEmailId + ", account=" + account + "]";
	}

}