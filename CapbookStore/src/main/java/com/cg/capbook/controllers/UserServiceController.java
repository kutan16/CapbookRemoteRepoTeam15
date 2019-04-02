
package com.cg.capbook.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.exceptions.EmailAlreadyExistException;
import com.cg.capbook.exceptions.UserNotFoundException;
import com.cg.capbook.services.UserServices;

@Controller
public class UserServiceController {
	
	@Autowired
	private UserServices userServices;
	
	@RequestMapping("/registerUser")
	public ModelAndView registerUser(@Valid @ModelAttribute UserAccount userAccount,String password,BindingResult result) throws EmailAlreadyExistException {
		if(result.hasErrors())
			return new ModelAndView("RegistrationPage");
		userAccount=userServices.acceptUserDetails(userAccount);
		userAccount.setPassword(userServices.encryptPassword(password));
		return new ModelAndView("RegistrationSuccessPage","userAccount",userAccount);
	} 

	@PostMapping(value = "/loginUser")
	  public String login(@ModelAttribute("login") UserAccount userAccount, BindingResult result, ModelMap model) {
		userServices.validateUser(userAccount);
		userServices.decryptPassword(userAccount.getPassword());
	    return "userProfilePage";
	  }
	
	@RequestMapping("/forgotPasswordService")
	public ModelAndView forgotPassword(@RequestParam String emailId, @RequestParam String question,
			@RequestParam String password) throws Exception {
		UserAccount userAccount = userServices.findAccountByEmailId(emailId);
		if (userAccount.getSecurityQuestion().equalsIgnoreCase(question)) {
			userAccount = userServices.acceptUserDetails(userAccount);
			userAccount.setPassword(userServices.encryptPassword(password));
			return new ModelAndView("forgetPasswordSuccessPage", "userAccount", userAccount);
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

	@RequestMapping("/logoutUser")
	public ModelAndView registerUser(@Valid @ModelAttribute UserAccount userAccount, BindingResult result, ModelMap model) throws EmailAlreadyExistException {
		if(result.hasErrors())
			return new ModelAndView("userProfilePage");
		userServices.userLogout();
		return new ModelAndView("LogoutSuccessPage","userAccount",null);
	}
	
	@RequestMapping("/saveImage")
	public ModelAndView editPic(@RequestParam MultipartFile file, HttpSession session) throws UserNotFoundException {
		return new ModelAndView("ImageUploadPage", "userAccount", userServices.addPhoto((String) session.getAttribute("emailId"), file));
				
	}
}
