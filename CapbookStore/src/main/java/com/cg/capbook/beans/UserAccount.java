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
	private List<Comment> comment;
	@OneToMany(mappedBy="userAccount",cascade=CascadeType.ALL)
	private List<Status> status;
	@OneToMany(mappedBy="userAccount",cascade=CascadeType.ALL)
	private List<Photo> photo;
	@Embedded
	private Data data;
	public UserAccount() {
		super();
	}
	public UserAccount(String emailId, String firstName, String lastName, String gender, String mobileNo,
			String dateOfBirth, String password, List<Comment> comment, List<Status> status, List<Photo> photo,
			Data data) {
		super();
		this.emailId = emailId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.dateOfBirth = dateOfBirth;
		this.password = password;
		this.comment = comment;
		this.status = status;
		this.photo = photo;
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
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	public List<Status> getStatus() {
		return status;
	}
	public void setStatus(List<Status> status) {
		this.status = status;
	}
	public List<Photo> getPhoto() {
		return photo;
	}
	public void setPhoto(List<Photo> photo) {
		this.photo = photo;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "UserAccount [emailId=" + emailId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", mobileNo=" + mobileNo + ", dateOfBirth=" + dateOfBirth + ", password=" + password
				+ ", comment=" + comment + ", status=" + status + ", photo=" + photo + ", data=" + data + "]";
	}
	
}