package com.cg.capbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capbook.beans.UserDislike;
import com.cg.capbook.beans.UserLike;

public interface DislikesDao extends JpaRepository<UserDislike, Integer>{
	/*@Query("from Dislikes where POSTS_POST_ID=:postId and dislikedBy=:dislikedBy")
	Dislikes getDisLikeByStatus(@Param("postId")Integer postId, @Param("dislikedBy")String dislikedBy);
	@Query("select count(*) from Dislikes where dislikecount=1 and POSTS_POST_ID=:postId")
	Integer getDislikeCount(@Param("postId")Integer postId);
	*/
	
	@Query("from UserDislike where POSTS_POST_ID=:postId and DISLIKED_BY=:dislikedBy")
	UserDislike getDisLikeByStatus(@Param("postId")Integer postId, @Param("dislikedBy")String dislikedBy);
	@Query("select count(*) from UserDislike where DISLIKECOUNT=1 and POSTS_POST_ID=:postId")
	Integer getDislikeCount(@Param("postId")Integer postId);
}