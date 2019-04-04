package com.cg.capbook.beans;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
//abcd
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int postId;
	private String postContent,postPic;
	@ManyToOne
	private UserAccount userAccount;

	
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postContent=" + postContent + ", postPic=" + postPic + ", userAccount="
				+ userAccount + "]";
	}
	public UserAccount getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(int postId, String postContent, String postPic, UserAccount userAccount) {
		super();
		this.postId = postId;
		this.postContent = postContent;
		this.postPic = postPic;
		this.userAccount = userAccount;
	}
	public Post(String postContent, UserAccount userAccount) {
				this.postContent=postContent;
				this.userAccount=userAccount;
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
	public UserAccount getAccount() {
		return userAccount;
	}
	public void setAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	

}