package com.cg.capbook.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserAccount {

	@Id
	private String emailId;
	private String firstName,lastName,gender,mobileNo,dateOfBirth,password;
	
	@OneToMany(mappedBy="userAccount",cascade=CascadeType.ALL)
	private List<UserComment> ccomment;
	
	@OneToMany(mappedBy="userAccount",cascade=CascadeType.ALL)
	private List<UserStatus> sstatus;
	
	@OneToMany(mappedBy="userAccount",cascade=CascadeType.ALL)
	private List<UserPhoto> pphoto;
	
	@Embedded
	private UserData data;
	public UserAccount() {
		super();
	}
	public UserAccount(String emailId, String firstName, String lastName, String gender, String mobileNo,
			String dateOfBirth, String password, List<UserComment> comment, List<UserStatus> status, List<UserPhoto> photo,
			UserData data) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.ccomment = comment;
		this.sstatus = status;
		this.pphoto = photo;
		this.data = data;
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
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<UserComment> getComment() {
		return ccomment;
	}
	public void setComment(List<UserComment> comment) {
		this.ccomment = comment;
	}
	public List<UserStatus> getStatus() {
		return sstatus;
	}
	public void setStatus(List<UserStatus> status) {
		this.sstatus = status;
	}
	public List<UserPhoto> getPhoto() {
		return pphoto;
	}
	public void setPhoto(List<UserPhoto> photo) {
		this.pphoto = photo;
	}
	public UserData getData() {
		return data;
	}
	public void setData(UserData data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "UserAccount [emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", mobileNo=" + mobileNo + ", dateOfBirth=" + dateOfBirth + ", password=" + password
				+ ", comment=" + ccomment + ", status=" + sstatus + ", photo=" + pphoto + ", data=" + data + "]";
	}
	
}