package com.cg.capbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.beans.Post;
import com.cg.capbook.beans.UserLike;
import com.cg.capbook.dao.LikesDao;
import com.cg.capbook.dao.PostDao;
@Component("likeServices")
public class LikesServicesImpl implements LikesServices{
	@Autowired
	private LikesDao likesDao;
	@Autowired 
	private PostDao postDao;

	@Override
	public UserLike updateLikes(int postId, String likedBy) {
		UserLike alreadyLikedAccount=likesDao.getLikeByStatus(postId, likedBy);
		if(alreadyLikedAccount!=null) {
			if(alreadyLikedAccount.getlikecount()==1){
				alreadyLikedAccount.setlikecount(0);
				return likesDao.save(alreadyLikedAccount);
			}else {
				alreadyLikedAccount.setlikecount(1);
				return likesDao.save(alreadyLikedAccount);
			}
		}
		return likesDao.save(new UserLike(likedBy, 1, postDao.findById(postId).orElse(null)));
	}
	@Override
	public int getLikesCount(int postId) {
		Post post=postDao.findById(postId).orElse(null);
		post.setTotalLikeCount(likesDao.getLikeCount(postId));
		postDao.save(post);
		return post.getTotalLikeCount();
	}

}
