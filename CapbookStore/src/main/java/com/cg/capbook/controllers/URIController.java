package com.cg.capbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.UserLogin;

@Controller
public class URIController {
	private UserAccount userAccount;
	private UserLogin userLogin;
	
	@RequestMapping(value= {"/","index"})
	public String getIndexPage() {
		return "IndexPage";
	}
	
	@RequestMapping("/registrationPage")
	public String getRegistrationPage() {
		return "RegistrationPage";
	}
	
	@RequestMapping("/loginPage")
	public String getLoginPage() {
		return "LoginPage";
	}
	
	@RequestMapping("/changePassword")
	public String getchangePasswordPage() {
		return "changePasswordPage";
	}
	
	@RequestMapping("/forgetPassword")
	public String getforgetPasswordPage() {
		return "forgetPasswordPage";
	}
	
	@RequestMapping("/logout")
	public String getLogout() {
		return "userProfilePage";
	}
	
	@ModelAttribute
	public UserAccount userAccount() {
		userAccount=new UserAccount();
		return userAccount;
	}
	
	@ModelAttribute
	public UserLogin userLogin() {
		userLogin=new UserLogin();
		return userLogin;
	}
}
