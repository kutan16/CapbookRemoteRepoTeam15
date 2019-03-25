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
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull
	private Date dateOfBirth;
	@NotEmpty
	private String password;
	
	private LocalDate currentDate;
	
	File profilePictureFile;
	
	@Embedded
	private UserData data;
	
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

	public UserAccount(String emailId, String firstName, String lastName, String gender, String mobileNo,
			Date dateOfBirth, String password) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
	}

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}

	public File getProfilePictureFile() {
		return profilePictureFile;
	}

	public void setProfilePictureFile(File profilePictureFile) {
		this.profilePictureFile = profilePictureFile;
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

	@Override
	public String toString() {
		return "UserAccount [emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", mobileNo=" + mobileNo + ", dateOfBirth=" + dateOfBirth + ", password=" + password + "]";
	}

}