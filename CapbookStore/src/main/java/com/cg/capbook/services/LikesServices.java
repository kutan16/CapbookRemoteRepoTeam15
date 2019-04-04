package com.cg.capbook.services;

import com.cg.capbook.beans.UserLike;

public interface LikesServices {
	public UserLike updateLikes(int postId, String likedBy);
	public int getLikesCount(int postId);
}
