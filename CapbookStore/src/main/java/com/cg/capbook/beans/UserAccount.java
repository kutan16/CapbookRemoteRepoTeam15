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
	@NotEmpty 
	String securityQuestion;
	
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

	public UserAccount(@NotEmpty String emailId, @NotEmpty String firstName, @NotEmpty String lastName,
			@NotEmpty String gender, @NotEmpty String mobileNo, @NotNull Date dateOfBirth, @NotEmpty String password,
			@NotEmpty String securityQuestion, LocalDate currentDate, File profilePictureFile, UserData data,
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

	public String getsecurityQuestion() {
		return securityQuestion;
	}

	public void setsecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
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

	@Override
	public String toString() {
		return "UserAccount [emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", mobileNo=" + mobileNo + ", dateOfBirth=" + dateOfBirth + ", password=" + password
				+ ", securityQuestion=" + securityQuestion + ", currentDate=" + currentDate
				+ ", profilePictureFile=" + profilePictureFile + ", data=" + data + ", userPhotos=" + userPhotos
				+ ", userStatus=" + userStatus + ", userFriend=" + userFriend + ", friendRequest=" + friendRequest
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentDate == null) ? 0 : currentDate.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((friendRequest == null) ? 0 : friendRequest.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((securityQuestion == null) ? 0 : securityQuestion.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mobileNo == null) ? 0 : mobileNo.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((profilePictureFile == null) ? 0 : profilePictureFile.hashCode());
		result = prime * result + ((userFriend == null) ? 0 : userFriend.hashCode());
		result = prime * result + ((userPhotos == null) ? 0 : userPhotos.hashCode());
		result = prime * result + ((userStatus == null) ? 0 : userStatus.hashCode());
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
		UserAccount other = (UserAccount) obj;
		if (currentDate == null) {
			if (other.currentDate != null)
				return false;
		} else if (!currentDate.equals(other.currentDate))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (friendRequest == null) {
			if (other.friendRequest != null)
				return false;
		} else if (!friendRequest.equals(other.friendRequest))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (securityQuestion == null) {
			if (other.securityQuestion != null)
				return false;
		} else if (!securityQuestion.equals(other.securityQuestion))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mobileNo == null) {
			if (other.mobileNo != null)
				return false;
		} else if (!mobileNo.equals(other.mobileNo))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (profilePictureFile == null) {
			if (other.profilePictureFile != null)
				return false;
		} else if (!profilePictureFile.equals(other.profilePictureFile))
			return false;
		if (userFriend == null) {
			if (other.userFriend != null)
				return false;
		} else if (!userFriend.equals(other.userFriend))
			return false;
		if (userPhotos == null) {
			if (other.userPhotos != null)
				return false;
		} else if (!userPhotos.equals(other.userPhotos))
			return false;
		if (userStatus == null) {
			if (other.userStatus != null)
				return false;
		} else if (!userStatus.equals(other.userStatus))
			return false;
		return true;
	}




}