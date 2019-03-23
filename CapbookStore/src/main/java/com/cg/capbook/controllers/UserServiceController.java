package com.cg.capbook.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.UserLogin;
import com.cg.capbook.exceptions.EmailAlreadyExistException;
import com.cg.capbook.services.LoginService;
import com.cg.capbook.services.UserServices;

@Controller
public class UserServiceController {
	
	@Autowired
	private UserServices userServices;
	@Autowired
	private LoginService loginServices;
	
	@RequestMapping("/registerUser")
	public ModelAndView registerUser(@Valid @ModelAttribute UserAccount userAccount,BindingResult result) throws EmailAlreadyExistException {
		if(result.hasErrors())
			return new ModelAndView("RegistrationPage");
		userAccount=userServices.acceptUserDetails(userAccount);
		return new ModelAndView("RegistrationSuccessPage","userAccount",userAccount);
	}
	
	@RequestMapping("/loginUser/{emailId}/{password}")
	public ModelAndView checkLogin( @PathVariable("emailId") String emailId,@PathVariable("password") String password,BindingResult result){
		if(result.hasErrors())
			return new ModelAndView("LoginPage");
		loginServices.checkUser(emailId,password);
		return new ModelAndView("userProfilePage","userLogin",loginServices.checkUser(emailId,password))	;	
	} 
}
