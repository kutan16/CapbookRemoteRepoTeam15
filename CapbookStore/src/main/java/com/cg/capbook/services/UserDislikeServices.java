package com.cg.capbook.services;

import com.cg.capbook.beans.UserDislike;

public interface UserDislikeServices {
	public UserDislike updateDislikes(int postId, String dislikedBy);
	public int getDislikesCount(int postId);
}
