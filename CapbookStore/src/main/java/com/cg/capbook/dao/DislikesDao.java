//package com.cg.capbook.daoservices;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.cg.capbook.beans.Dislikes;
//import com.cg.capbook.beans.Likes;
//
//public interface DislikesDao extends JpaRepository<Dislikes, Integer>{
//	/*@Query("from Dislikes where POSTS_POST_ID=:postId and dislikedBy=:dislikedBy")
//	Dislikes getDisLikeByStatus(@Param("postId")Integer postId, @Param("dislikedBy")String dislikedBy);
//	@Query("select count(*) from Dislikes where dislikecount=1 and POSTS_POST_ID=:postId")
//	Integer getDislikeCount(@Param("postId")Integer postId);
//	*/
//	
//	@Query("from Dislikes where POSTS_POST_ID=:postId and DISLIKED_BY=:dislikedBy")
//	Dislikes getDisLikeByStatus(@Param("postId")Integer postId, @Param("dislikedBy")String dislikedBy);
//	@Query("select count(*) from Dislikes where DISLIKECOUNT=1 and POSTS_POST_ID=:postId")
//	Integer getDislikeCount(@Param("postId")Integer postId);
//}