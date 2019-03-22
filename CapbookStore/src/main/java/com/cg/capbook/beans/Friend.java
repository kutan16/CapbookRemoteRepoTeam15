package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Friend {
	@Id
	private int friendId;
	private String friendName;
	public Friend() {
		super();
	}
	public Friend(int friendId, String friendName) {
		super();
		this.friendId = friendId;
		this.friendName = friendName;
	}
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	public String getFriendName() {
		return friendName;
	}
	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}
	@Override
	public String toString() {
		return "Friend [friendId=" + friendId + ", friendName=" + friendName + "]";
	}
	
}
