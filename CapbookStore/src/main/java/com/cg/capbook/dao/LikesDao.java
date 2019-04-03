//package com.cg.capbook.daoservices;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.cg.capbook.beans.Likes;
//
//public interface LikesDao extends JpaRepository<Likes, Integer>{
//	@Query("from Likes where POSTS_POST_ID=:postId and likedBy=:likedBy")
//	Likes getLikeByStatus(@Param("postId")Integer postId, @Param("likedBy")String likedBy);
//	@Query("select count(*) from Likes where likecount=1 and POSTS_POST_ID=:postId")
//	Integer getLikeCount(@Param("postId")Integer postId);
//}