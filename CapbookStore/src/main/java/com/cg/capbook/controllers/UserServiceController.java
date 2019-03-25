package com.cg.capbook.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.UserLogin;
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

	@RequestMapping("/forgotPasswordService")
	public ModelAndView forgotPassword(@RequestParam String emailId, @RequestParam String question,
			@RequestParam String password) throws Exception {
		UserAccount userAccount = userServices.findAccountByEmailId(emailId);
		if (userAccount.getsecurityQuestion().equalsIgnoreCase(question)) {
			String encryptPassword = "abc" + password + "def";
			userAccount.setPassword(encryptPassword);
			userAccount = userServices.acceptUserDetails(userAccount);
			return new ModelAndView("forgotPasswordSuccessPage", "UserAccount", userAccount);

		} else
			return new ModelAndView("errorPage", "error", userAccount);

	}

	@RequestMapping("/changePasswordService")
	public ModelAndView changePassword(@RequestParam String emailId, @RequestParam String cpassword,
			@RequestParam String password) throws Exception {
		UserAccount UserAccount = userServices.findAccountByEmailId(emailId);
		if (password.equalsIgnoreCase(cpassword)) {
			String encryptPassword = "abc" + password + "def";
			UserAccount.setPassword(encryptPassword);
			UserAccount = userServices.acceptUserDetails(UserAccount);
			return new ModelAndView("forgotPasswordSuccessPage", "UserAccount", UserAccount);

		} else
			return new ModelAndView("errorPage", "error", UserAccount);

	}

}
