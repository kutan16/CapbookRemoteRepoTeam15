package com.cg.capbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.Post;
import com.cg.capbook.dao.PostDao;
import com.cg.capbook.dao.UserDAO;
import com.cg.capbook.exceptions.InvalidEmailException;;

@Component("postServices")
public class PostServicesImpl implements PostServices{
	@Autowired
	private UserDAO accountDao;
	@Autowired
	private PostDao postDao;

	@Autowired
	PostServices postServices;
	@Override
	public Post savePost(String emailId, String postMessage) {
		UserAccount userAccount=accountDao.findById(emailId).orElse(null);
		Post post=new Post(postMessage, userAccount);
		return postDao.save(post);
	}
	@Override
	public List<Post> ShowAllPosts(String emailId) {
		return postDao.showAllPosts(emailId);
		
	}
	public boolean deletePost(int postId) {
		postDao.deleteById(postId);
		return true;
	}

}
	
	
