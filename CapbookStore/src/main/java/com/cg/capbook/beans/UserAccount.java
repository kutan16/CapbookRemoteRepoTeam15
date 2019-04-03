package com.cg.capbook.beans;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class UserAccount {

	@Id
	private String emailId;
	
	private String firstName;
	
	private String lastName;
	
	private String gender;
	
	private String mobileNo;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dateOfBirth;
	
	private String password;
	
	private String securityQuestion;
	
	private LocalDate currentDate;
	
	private String profilePictureFile;
	
	private String education;
	
	private String city;
	
	private String state;
	
	private String address;
	
	private String hobbies;
	
//	@Embedded
//	private UserData data;
	
	@OneToMany(mappedBy="userAccount")
	private List<UserPhoto> userPhotos;
	
	@OneToMany(mappedBy="userAccount")
	private List<UserStatus> userStatus;
	
	@OneToMany(mappedBy="account")
	private List<UserFriend> userFriend;
	

	public UserAccount() {
		
	}

	public UserAccount(String emailId, String firstName, String lastName, String gender, String mobileNo,
			Date dateOfBirth, String password, String securityQuestion, LocalDate currentDate,
			String profilePictureFile, String education, String city, String state, String address, String hobbies,
			List<UserPhoto> userPhotos, List<UserStatus> userStatus, List<UserFriend> userFriend) {
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
		this.education = education;
		this.city = city;
		this.state = state;
		this.address = address;
		this.hobbies = hobbies;
		this.userPhotos = userPhotos;
		this.userStatus = userStatus;
		this.userFriend = userFriend;
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

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}

	public String getProfilePictureFile() {
		return profilePictureFile;
	}

	public void setProfilePictureFile(String profilePictureFile) {
		this.profilePictureFile = profilePictureFile;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
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

	@Override
	public String toString() {
		return "UserAccount [emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", mobileNo=" + mobileNo + ", dateOfBirth=" + dateOfBirth + ", password=" + password
				+ ", securityQuestion=" + securityQuestion + ", currentDate=" + currentDate + ", profilePictureFile="
				+ profilePictureFile + ", education=" + education + ", city=" + city + ", state=" + state + ", address="
				+ address + ", hobbies=" + hobbies + ", userPhotos=" + userPhotos + ", userStatus=" + userStatus
				+ ", userFriend=" + userFriend + "]";
	}
	
	
	
}