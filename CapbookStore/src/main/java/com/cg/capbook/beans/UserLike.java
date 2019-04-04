package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class UserLike {
	@Id
	@SequenceGenerator(name="likes",sequenceName="like_seq",initialValue=1001,allocationSize=10000)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="likes")
	private Integer likeId;
	private String likedBy;
	private int likecount;
	@ManyToOne
	private Post posts;
	
	public UserLike() {}

	public UserLike(String likedBy, int likecount, Post posts) {
		super();
		this.likedBy = likedBy;
		this.likecount = likecount;
		this.posts = posts;
	}
	
	public Integer getLikeId() {
		return likeId;
	}
	public void setLikeId(Integer likeId) {
		this.likeId = likeId;
	}
	public String getLikedBy() {
		return likedBy;
	}
	public void setLikedBy(String likedBy) {
		this.likedBy = likedBy;
	}
	public int getlikecount() {
		return likecount;
	}
	public void setlikecount(int likecount) {
		this.likecount = likecount;
	}
	public Post getposts() {
		return posts;
	}
	public void setposts(Post posts) {
		this.posts = posts;
	}
	@Override
	public String toString() {
		return "Likes [likeId=" + likeId + ", likedBy=" + likedBy + ", likecount="
				+ likecount + ", posts=" + posts + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((likeId == null) ? 0 : likeId.hashCode());
		result = prime * result + likecount;
		result = prime * result + ((likedBy == null) ? 0 : likedBy.hashCode());
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserLike other = (UserLike) obj;
		if (likeId == null) {
			if (other.likeId != null)
				return false;
		} else if (!likeId.equals(other.likeId))
			return false;
		if (likecount != other.likecount)
			return false;
		if (likedBy == null) {
			if (other.likedBy != null)
				return false;
		} else if (!likedBy.equals(other.likedBy))
			return false;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		return true;
	}
	
}
