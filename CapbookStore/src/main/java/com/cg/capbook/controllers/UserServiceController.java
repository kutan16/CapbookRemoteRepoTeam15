package com.cg.capbook.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.services.UserServices;

@Controller
public class UserServiceController {
	
	@Autowired
	private UserServices userServices;
	
	@RequestMapping("/RegisterUser")
	public ModelAndView registerUser(@Valid@ModelAttribute UserAccount user,BindingResult result) {
		if(result.hasErrors()) return new ModelAndView("RegistrationPage");
		user=userServices.acceptUserDetails(user);
		return new ModelAndView("RegistrationSuccessPage","user",user);
	}
}
