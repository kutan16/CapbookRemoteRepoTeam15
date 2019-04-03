package com.cg.capbook.services;

import java.util.List;

import com.cg.capbook.beans.Relationship;
import com.cg.capbook.beans.UserFriend;
import com.cg.capbook.exceptions.InvalidEmailException;
import com.cg.capbook.exceptions.UserNotFoundException;

public interface UserFriendService {

	public boolean sendFriendRequest(String senderId, String receiverId) throws InvalidEmailException, UserNotFoundException; 
	public boolean confirmFriendRequest(String senderId,String receiverId) throws InvalidEmailException, UserNotFoundException; 
	public boolean removeFriend(String senderId,String receiverId) throws InvalidEmailException; 
	public boolean rejectFriendRequest(String senderId,String receiverId); 
	public List<Relationship> showAllFriendRequests(String emailId); 
	public List<Relationship> showAllSentFriendRequests(String emailId); 
	public Relationship findFriendRequest(String senderId,String receiverId); 
	public List<UserFriend> showAllFriends(String emailId)throws InvalidEmailException;
}
