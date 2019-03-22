package com.cg.capbook.beans;

import java.io.File;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
@Entity
public class Photo {
	@Id
	private String username;
	private String imageURL;
	private File file;
	private String album;
	@ManyToOne
	private UserAccount userAccount;
	
	@OneToMany(mappedBy="photo", cascade=CascadeType.ALL)
	@MapKey
	private Map<Integer, Like> like;
	
	@OneToMany(mappedBy="comment", cascade=CascadeType.ALL)
	@MapKey
	private Map<Integer, Comment> comment;
	
	@OneToMany(mappedBy="tag", cascade=CascadeType.ALL)
	@MapKey
	private Map<Integer, Tag> tag;

	public Photo() {
		super();
	}

	public Photo(String username, String imageURL, File file, String album, UserAccount userAccount,
			Map<Integer, Like> like, Map<Integer, Comment> comment, Map<Integer, Tag> tag) {
		super();
		this.username = username;
		this.imageURL = imageURL;
		this.file = file;
		this.album = album;
		this.userAccount = userAccount;
		this.like = like;
		this.comment = comment;
		this.tag = tag;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public Map<Integer, Like> getLike() {
		return like;
	}

	public void setLike(Map<Integer, Like> like) {
		this.like = like;
	}

	public Map<Integer, Comment> getComment() {
		return comment;
	}

	public void setComment(Map<Integer, Comment> comment) {
		this.comment = comment;
	}

	public Map<Integer, Tag> getTag() {
		return tag;
	}

	public void setTag(Map<Integer, Tag> tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Photo [username=" + username + ", imageURL=" + imageURL + ", file=" + file + ", album=" + album
				+ ", userAccount=" + userAccount + ", like=" + like + ", comment=" + comment + ", tag=" + tag + "]";
	}

}
