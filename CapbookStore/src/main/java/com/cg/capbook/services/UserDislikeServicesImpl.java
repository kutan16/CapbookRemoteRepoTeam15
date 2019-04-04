package com.cg.capbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.beans.UserDislike;
import com.cg.capbook.beans.UserLike;
import com.cg.capbook.beans.Post;
import com.cg.capbook.dao.DislikesDao;
import com.cg.capbook.dao.PostDao;
@Component("dislikeServices")
public class UserDislikeServicesImpl implements UserDislikeServices{
	@Autowired
	private DislikesDao dislikesDao;
	@Autowired 
	private PostDao postDao;
	
	@Override
	public UserDislike updateDislikes(int postId, String dislikedBy) {
		UserDislike alreadyDislikedAccount=dislikesDao.getDisLikeByStatus(postId, dislikedBy);
		if(alreadyDislikedAccount!=null) {
			if(alreadyDislikedAccount.getDislikecount()==1){
				alreadyDislikedAccount.setDislikecount(0);
				return dislikesDao.save(alreadyDislikedAccount);
			}else {
				alreadyDislikedAccount.setDislikecount(1);
				return dislikesDao.save(alreadyDislikedAccount);
			}
		}
		return dislikesDao.save(new UserDislike(dislikedBy, 1, postDao.findById(postId).orElse(null)));
	}

	@Override
	public int getDislikesCount(int postId) {
		Post post=postDao.findById(postId).orElse(null);
		post.setTotalDislikeCount(dislikesDao.getDislikeCount(postId));
		postDao.save(post);
		return post.getTotalDislikeCount();
	}

}
