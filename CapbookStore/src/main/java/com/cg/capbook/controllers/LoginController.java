package com.cg.capbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.UserLogin;
import com.cg.capbook.services.UserServices;
@Controller
public class LoginController {
	@Autowired
	  public UserServices userServices;

	  @PostMapping(value = "/loginUser")
	  public String login(@ModelAttribute("login") UserLogin userLogin, BindingResult result, ModelMap model) {
	    UserAccount userAccount = userServices.validateUser(userLogin);
	    boolean isValidUser = false;
	    if (null != userAccount && userAccount.getEmailId().equals(userLogin.getEmailId())
	        && userAccount.getPassword().equals(userLogin.getPassword())) {
	      isValidUser = true;
	      model.addAttribute("emailId", userAccount.getEmailId());
	    }
	    return isValidUser ? "userProfilePage" : "loginPage";
	  }
}

