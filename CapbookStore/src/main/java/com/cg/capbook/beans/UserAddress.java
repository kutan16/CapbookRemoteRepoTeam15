package com.cg.capbook.beans;
import javax.persistence.Embeddable;

@Embeddable
public class UserAddress {
	String state;
	String city;
	String houseNumber;
	String country;
	public UserAddress() {
		super();
	}
	public UserAddress(String state, String city, String houseNumber, String country) {
		super();
		this.state = state;
		this.city = city;
		this.houseNumber = houseNumber;
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", houseNumber=" + houseNumber + ", country=" + country
				+ "]";
	}
}
