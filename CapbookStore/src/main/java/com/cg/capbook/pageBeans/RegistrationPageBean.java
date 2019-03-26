package com.cg.capbook.pageBeans;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPageBean {
	
	@FindBy(how=How.NAME,name="emailId")
	private WebElement emailId;
	
	@FindBy(how=How.NAME,name="password")
	private WebElement password;
			
	@FindBy(how=How.NAME,name="gender")
	private List<WebElement> gender;

	@FindBy(how=How.NAME,name="firstName")
	private WebElement firstName;
	
	@FindBy(how=How.NAME,name="lastName")
	private WebElement lastName;
	
	@FindBy(how=How.NAME,name="mobileNo")
	private WebElement mobileNo;
	
	@FindBy(how=How.NAME,name="dateOfBirth")
	private Date dateOfBirth;
	
	@FindBy(how=How.NAME,name="submit")
	private WebElement submitBtn;
	
	public String getPassword() {
		return password.getAttribute("value");
	}

	public void setPassword(String password) {
		this.password.sendKeys(password);;
	}

	public String getFirstName() {
		return firstName.getAttribute("value");
	}

	public void setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);;
	}

	public String getlastName() {
		return lastName.getAttribute("value");
	}

	public void setlastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
	
	public String getMobileNo() {
		return mobileNo.getAttribute("value");
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo.sendKeys(mobileNo);
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return emailId.getAttribute("value");
	}

	public void setEmailId(String emailId) {
		this.emailId.sendKeys(emailId);
	}

	public String getGender() {
		for(WebElement element:gender)
			if(element.isSelected())
				return element.getAttribute("value");
		return null;
	}

	public void setGender(String gender) {
		if(gender.equalsIgnoreCase("male"))
			this.gender.get(0).click();
		
		else
			this.gender.get(1).click();
	}


	public WebElement getSubmitBtn() {
		return getSubmitBtn();
	}

	public void setSubmitBtn(WebElement submitBtn) {
		this.submitBtn = submitBtn;
	}
}
