package com.cg.capbook.beans;

import javax.persistence.Embeddable;
@Embeddable
public class Address {
	private String city;
	private String state;
	private String country;
	private int zipCode;
	public Address () {}
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public Address(String city, String state, String country, int zipCode) {
		super();
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

}