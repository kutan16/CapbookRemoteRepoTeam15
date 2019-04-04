package com.cg.capbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.beans.Post;
import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.UserFriend;
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
	
	@Autowired
	UserFriendService friendServices;
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
	@Override
	public List<Post> ShowAllFriendsPosts(String emailId) throws InvalidEmailException {
		List<Post> allPosts=new ArrayList<Post>();
		List<UserFriend> allfriends=friendServices.showAllFriends(emailId);
		
		for(UserFriend friend : allfriends) {
			List<Post> friendPost=ShowAllPosts(friend.getFriendEmailId());
			for(Post post : friendPost) {
			   allPosts.add(post);
			}
			
		}
		List<Post> MyPost=ShowAllPosts(emailId);
		for(Post post : MyPost) {
			   allPosts.add(post);
			}
		return allPosts;
	
}
}
	
	
