
package com.cg.capbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.beans.Relationship;
import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.UserFriend;
import com.cg.capbook.dao.FriendsDao;
import com.cg.capbook.dao.RelationshipDao;
import com.cg.capbook.exceptions.InvalidEmailException;
import com.cg.capbook.exceptions.UserNotFoundException;


@Component("friendServices")
public class UserFriendServicesImpl implements UserFriendService{
	@Autowired 
	private UserServices userServices;

	@Autowired 
	private RelationshipDao relationshipDao;

	@Autowired 
	private FriendsDao friendsDao;



	@Override public boolean sendFriendRequest(String senderId, String receiverId) throws InvalidEmailException, UserNotFoundException { 
		userServices.findAccountByEmailId(senderId); 
		userServices.findAccountByEmailId(receiverId);
		Relationship relationship = new Relationship(); 
		relationship.setSenderEmailId(senderId);
		relationship.setReceiverEmailId(receiverId);
		relationship.setStatus("pending");
		relationshipDao.save(relationship);
		return true; 
	}
	@Override
	public boolean confirmFriendRequest(String senderId, String receiverId) throws InvalidEmailException, UserNotFoundException {

		UserAccount senderAcc=userServices.findAccountByEmailId(senderId); 
		UserAccount recieverAcc=userServices.findAccountByEmailId(receiverId); 
		UserFriend friend1=new UserFriend(senderId, recieverAcc);
		friendsDao.save(friend1);
		UserFriend friend2=new UserFriend(receiverId, senderAcc);
		friendsDao.save(friend2);
		System.out.println(friend1.getFriendEmailId()+""+friend1.getAccount().getEmailId());
		System.out.println(friend2.getFriendEmailId()+""+friend2.getAccount().getEmailId());




		Relationship relation=findFriendRequest(senderId, receiverId);
		relation.setStatus("friends");
		relationshipDao.save(relation);
		return false;
	}
	@Override
	public boolean rejectFriendRequest(String senderId, String receiverId) {
		Relationship relation=findFriendRequest(senderId, receiverId);
		relation.setStatus("rejected");
		relationshipDao.save(relation);
		return false;
	}
	@Override
	public List<Relationship> showAllFriendRequests(String emailId) {
		return relationshipDao.showAllFriendRequests(emailId);
	}
	@Override
	public List<Relationship> showAllSentFriendRequests(String emailId) {
		return relationshipDao.showAllSentFriendRequests(emailId);
	}
	@Override
	public Relationship findFriendRequest(String senderId, String receiverId) {
		return relationshipDao.findFriendRequest(senderId, receiverId);
	}
	public List<UserFriend> showAllFriends(String emailId)throws InvalidEmailException{
		return friendsDao.showAllFriends(emailId);
	}
	@Override
	public boolean removeFriend(String accountId, String friendId) throws InvalidEmailException {
		Relationship relation=findFriendRequest(accountId, friendId);
		relationshipDao.delete(relation);
		//friendsDao.toDelete(accountId, friendId);
		return false;
	}
}

