package com.cg.capbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.capbook.beans.UserAccount;

@Controller
public class URIController {
	private UserAccount user;
	
	@RequestMapping(value= {"/","index"})
	public String getIndexPage() {
		return "IndexPage";
	}
	
	@RequestMapping("/RegistrationPage")
	public String getRegistrationPage() {
		return "RegistrationPage";
	}
	
	@RequestMapping("/LoginPage")
	public String getLoginPage() {
		return "LoginPage";
	}
}
