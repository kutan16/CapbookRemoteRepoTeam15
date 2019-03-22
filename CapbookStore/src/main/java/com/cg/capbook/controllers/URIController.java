package com.cg.capbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.capbook.beans.UserAccount;

@Controller
public class URIController {
	private UserAccount userAccount;
	
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
	
	@ModelAttribute
	public UserAccount userAccount() {
		userAccount=new UserAccount();
		return userAccount;
	}
}
