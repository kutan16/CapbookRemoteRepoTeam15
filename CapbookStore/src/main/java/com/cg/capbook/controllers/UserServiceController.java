package com.cg.capbook.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.exceptions.EmailAlreadyExistException;
import com.cg.capbook.services.UserServices;

@Controller
public class UserServiceController {
	
	@Autowired
	private UserServices userServices;
	
	@RequestMapping("/registerUser")
	public ModelAndView registerUser(@Valid @ModelAttribute UserAccount userAccount,BindingResult result) throws EmailAlreadyExistException {
		if(result.hasErrors())
			return new ModelAndView("RegistrationPage");
		userAccount=userServices.acceptUserDetails(userAccount);
		return new ModelAndView("RegistrationSuccessPage","userAccount",userAccount);
	}
	
	@RequestMapping("/loginUser")
	public ModelAndView loginUser(@Valid @ModelAttribute UserAccount userAccount,BindingResult result) throws EmailAlreadyExistException {
		if(result.hasErrors())
			return new ModelAndView("LoginPage");
		userAccount=userServices.acceptUserDetails(userAccount);
		return new ModelAndView("UserProfilePage","userAccount",userAccount);
	}
}
