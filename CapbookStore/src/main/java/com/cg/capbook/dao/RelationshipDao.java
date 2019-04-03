
  package com.cg.capbook.dao;
  
  import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capbook.beans.Relationship;
  
  public interface RelationshipDao extends JpaRepository<Relationship,Integer>{
	  @Query("delete from Relationship relation where relation.senderEmailId=:senderId and relation.receiverEmailId=:receiverId")
		public boolean deleteFriendRequest(@Param("senderId")String senderId, @Param("receiverId")String receiverId);
	  
	  @Query("from Relationship relation where relation.receiverEmailId=:emailId and relation.status Like 'pending'")
		public List<Relationship> showAllFriendRequests(@Param("emailId") String emailId); 
	  
	  @Query("from Relationship relation where relation.senderEmailId=:emailId")
		public List<Relationship> showAllSentFriendRequests(@Param("emailId") String emailId); 
	  
	  @Query("from Relationship relation where relation.senderEmailId=:senderId and relation.receiverEmailId=:receiverId")
	     public Relationship findFriendRequest(@Param("senderId")String senderId, @Param("receiverId")String receiverId);
  }

