package com.cg.capbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.capbook.beans.UserLike;

public interface LikesDao extends JpaRepository<UserLike, Integer>{
	@Query("from UserLike where POSTS_POST_ID=:postId and likedBy=:likedBy")
	UserLike getLikeByStatus(@Param("postId")Integer postId, @Param("likedBy")String likedBy);
	@Query("select count(*) from UserLike where likecount=1 and POSTS_POST_ID=:postId")
	Integer getLikeCount(@Param("postId")Integer postId);
}