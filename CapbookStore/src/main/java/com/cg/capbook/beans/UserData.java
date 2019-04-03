package com.cg.capbook.beans;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Id;
@Embeddable
public class UserData {
	private String education;
	private String city;
	private String state;
	private String address;
	private String hobbies;
	public UserData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserData( String education, String city, String state, String address, String hobbies) {
		super();
		
		this.education = education;
		this.city = city;
		this.state = state;
		this.address = address;
		this.hobbies = hobbies;
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
	
}
