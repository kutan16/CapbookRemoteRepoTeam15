package com.cg.capbook.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class UserDislike {

	@Id
	@SequenceGenerator(name="dislikes",sequenceName="dislike_seq",initialValue=1001,allocationSize=10000)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="dislikes")
	private Integer dislikeId;
	private String dislikedBy;
	private int dislikecount;
	@ManyToOne
	private Post posts;
	public UserDislike() {}
	public UserDislike(Integer dislikeId, String dislikedBy, int dislikecount, Post posts) {
		super();
		this.dislikeId = dislikeId;
		this.dislikedBy = dislikedBy;
		this.dislikecount = dislikecount;
		this.posts = posts;
	}
	public UserDislike(String dislikedBy, int dislikecount, Post posts) {
		super();
		this.dislikedBy = dislikedBy;
		this.dislikecount = dislikecount;
		this.posts = posts;
	}
	public Integer getDislikeId() {
		return dislikeId;
	}
	public void setDislikeId(Integer dislikeId) {
		this.dislikeId = dislikeId;
	}
	public String getDislikedBy() {
		return dislikedBy;
	}
	public void setDislikedBy(String dislikedBy) {
		this.dislikedBy = dislikedBy;
	}
	public int getDislikecount() {
		return dislikecount;
	}
	public void setDislikecount(int dislikecount) {
		this.dislikecount = dislikecount;
	}
	public Post getPosts() {
		return posts;
	}
	public void setPosts(Post posts) {
		this.posts = posts;
	}
	@Override
	public String toString() {
		return "UserDislike [dislikeId=" + dislikeId + ", dislikedBy=" + dislikedBy + ", dislikecount=" + dislikecount
				+ ", posts=" + posts + "]";
	}
	
}
