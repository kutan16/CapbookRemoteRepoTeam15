package com.cg.capbook.beans;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
@Entity
public class UserPhoto {
	@Id
	private String photoId;
	private String imageURL;
	private File file;
	private String album;
	@ManyToOne
	private UserAccount userAccount;
	
	@OneToMany(mappedBy="pphoto", cascade=CascadeType.ALL)
	@MapKey
	private List<UserLike> llike;
	
	@OneToMany(mappedBy="pphoto", cascade=CascadeType.ALL)
	@MapKey
	private List<UserComment> ccomment;
	
	@OneToMany(mappedBy="pphoto", cascade=CascadeType.ALL)
	@MapKey
	private List<UserTag> ttag;

	public UserPhoto() {
		super();
	}

	public UserPhoto(String photoId, String imageURL, File file, String album, UserAccount userAccount, List<UserLike> like,
			List<UserComment> comment, List<UserTag> tag) {
		super();
		this.photoId = photoId;
		this.imageURL = imageURL;
		this.file = file;
		this.album = album;
		this.userAccount = userAccount;
		this.llike = like;
		this.ccomment = comment;
		this.ttag = tag;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
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

	
	public List<UserLike> getLike() {
		return llike;
	}

	public void setLike(List<UserLike> like) {
		this.llike = like;
	}

	public List<UserComment> getComment() {
		return ccomment;
	}

	public void setComment(List<UserComment> comment) {
		this.ccomment = comment;
	}

	public List<UserTag> getTag() {
		return ttag;
	}

	public void setTag(List<UserTag> tag) {
		this.ttag = tag;
	}

	@Override
	public String toString() {
		return "Photo [photoId=" + photoId + ", imageURL=" + imageURL + ", file=" + file + ", album=" + album
				+ ", userAccount=" + userAccount + ", like=" + llike + ", comment=" + ccomment + ", tag=" + ttag + "]";
	}

	
}
