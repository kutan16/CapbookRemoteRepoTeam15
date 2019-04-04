
 package com.cg.capbook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capbook.beans.UserFriend;
 public interface FriendsDao extends JpaRepository<UserFriend, String>{
	 
	  @Query("from UserFriend where USER_ACCOUNT_EMAIL_ID=:emailId")
			public List<UserFriend> showAllFriends(@Param("emailId") String emailId);
	
 }
 