package com.cg.capbook.beans;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
//abcd
@Entity
public class Post implements Comparable<Post>{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int postId;
	private String postContent,postPic;
	
	private int totalLikeCount;
	private int totalDislikeCount;
	
	@ManyToOne
	private UserAccount userAccount;
	@OneToMany(mappedBy="posts",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<UserLike> likes;
	@OneToMany(mappedBy="posts",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<UserDislike> dislikes;
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(int postId, String postContent, String postPic, int totalLikeCount, int totalDislikeCount,
			UserAccount userAccount, List<UserLike> likes, List<UserDislike> dislikes) {
		super();
		this.postId = postId;
		this.postContent = postContent;
		this.postPic = postPic;
		this.totalLikeCount = totalLikeCount;
		this.totalDislikeCount = totalDislikeCount;
		this.userAccount = userAccount;
		this.likes = likes;
		this.dislikes = dislikes;
	}

	public Post(String postContent, UserAccount userAccount) {
		this.postContent=postContent;
		this.userAccount=userAccount;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostPic() {
		return postPic;
	}

	public void setPostPic(String postPic) {
		this.postPic = postPic;
	}

	public int getTotalLikeCount() {
		return totalLikeCount;
	}

	public void setTotalLikeCount(int totalLikeCount) {
		this.totalLikeCount = totalLikeCount;
	}

	public int getTotalDislikeCount() {
		return totalDislikeCount;
	}

	public void setTotalDislikeCount(int totalDislikeCount) {
		this.totalDislikeCount = totalDislikeCount;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public List<UserLike> getLikes() {
		return likes;
	}

	public void setLikes(List<UserLike> likes) {
		this.likes = likes;
	}

	public List<UserDislike> getDislikes() {
		return dislikes;
	}

	public void setDislikes(List<UserDislike> dislikes) {
		this.dislikes = dislikes;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postContent=" + postContent + ", postPic=" + postPic + ", totalLikeCount="
				+ totalLikeCount + ", totalDislikeCount=" + totalDislikeCount + " likes=" + likes + ", dislikes=" + dislikes + "]";
	}
	@Override
	public int compareTo(Post comparePost) {
		 int compareId=((Post)comparePost).getPostId();
		 return compareId-this.postId;
	}
	
	
	
	
}