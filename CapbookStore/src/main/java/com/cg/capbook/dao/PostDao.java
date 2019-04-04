
package com.cg.capbook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.capbook.beans.Post;

public interface PostDao extends JpaRepository<Post, Integer>{
	@Query("from Post where USER_ACCOUNT_EMAIL_ID=:emailId order by postId desc")
	public List<Post> showAllPosts(String emailId);
}
