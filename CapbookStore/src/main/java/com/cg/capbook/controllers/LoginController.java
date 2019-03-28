package com.cg.capbook.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.UserLogin;
import com.cg.capbook.exceptions.EmailAlreadyExistException;
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
	        && userAccount.getPassword().equals("abc"+userLogin.getPassword()+"def")) {
	      isValidUser = true;
	      model.addAttribute("emailId", userAccount.getEmailId());
	    }
	    return isValidUser ? "userProfilePage" : "loginPage";
	  }

	  @RequestMapping("/logoutUser")
		public ModelAndView registerUser(@Valid @ModelAttribute UserLogin userLogin, BindingResult result, ModelMap model) throws EmailAlreadyExistException {
			if(result.hasErrors())
				return new ModelAndView("userProfilePage");
			userLogin.setEmailId(null);
			return new ModelAndView("LogoutSuccessPage","userLogin",null);
		}
}

