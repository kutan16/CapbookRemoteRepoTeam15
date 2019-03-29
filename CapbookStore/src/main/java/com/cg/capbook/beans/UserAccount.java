package com.cg.capbook.beans;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class UserAccount {

	@Id
	@NotEmpty
	private String emailId;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String gender;
	@NotEmpty
	private String mobileNo;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@NotNull
	private Date dateOfBirth;
	@NotEmpty
	private String password;
	
	private String securityQuestion;
	
	private LocalDate currentDate;
	
	private String profilePictureFile;
	
	@Embedded
	private UserData data;
	
	public UserAccount(@NotEmpty String emailId, @NotEmpty String firstName, @NotEmpty String lastName,
			@NotEmpty String gender, @NotEmpty String mobileNo, @NotNull Date dateOfBirth, @NotEmpty String password,
			String securityQuestion, LocalDate currentDate, String profilePictureFile, UserData data,
			List<UserPhoto> userPhotos, List<UserStatus> userStatus, List<UserFriend> userFriend,
			List<UserFriendRequest> friendRequest) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.securityQuestion = securityQuestion;
		this.currentDate = currentDate;
		this.profilePictureFile = profilePictureFile;
		this.data = data;
		this.userPhotos = userPhotos;
		this.userStatus = userStatus;
		this.userFriend = userFriend;
		this.friendRequest = friendRequest;
	}

	public void setProfilePictureFile(String profilePictureFile) {
		this.profilePictureFile = profilePictureFile;
	}

	@OneToMany(mappedBy="userAccount")
	private List<UserPhoto> userPhotos;
	
	@OneToMany(mappedBy="userAccount")
	private List<UserStatus> userStatus;
	
	@OneToMany(mappedBy="userAccount")
	private List<UserFriend> userFriend;
	
	@OneToMany(mappedBy="userAccount")
	private List<UserFriendRequest> friendRequest;
	
	public UserAccount() {
		super();
	}
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}

	public UserData getData() {
		return data;
	}

	public void setData(UserData data) {
		this.data = data;
	}

	public List<UserPhoto> getUserPhotos() {
		return userPhotos;
	}

	public void setUserPhotos(List<UserPhoto> userPhotos) {
		this.userPhotos = userPhotos;
	}

	public List<UserStatus> getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(List<UserStatus> userStatus) {
		this.userStatus = userStatus;
	}

	public List<UserFriend> getUserFriend() {
		return userFriend;
	}

	public void setUserFriend(List<UserFriend> userFriend) {
		this.userFriend = userFriend;
	}

	public List<UserFriendRequest> getFriendRequest() {
		return friendRequest;
	}

	public void setFriendRequest(List<UserFriendRequest> friendRequest) {
		this.friendRequest = friendRequest;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getProfilePictureFile() {
		return profilePictureFile;
	}

}