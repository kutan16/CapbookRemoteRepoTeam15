
package com.cg.capbook.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.beans.Post;
import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.exceptions.EmailAlreadyExistException;
import com.cg.capbook.exceptions.InvalidEmailException;
import com.cg.capbook.exceptions.InvalidPasswordException;
import com.cg.capbook.exceptions.UserNotFoundException;
import com.cg.capbook.services.PostServices;
import com.cg.capbook.services.UserServices;

@Controller
public class UserServiceController {

	@Autowired
	private UserServices userServices;



	@Autowired
	PostServices postServices;

	//User Controller

	@RequestMapping("/registerUser")
	public ModelAndView registerUser(@Valid @ModelAttribute UserAccount userAccount,String password,BindingResult result) throws EmailAlreadyExistException {
		if(result.hasErrors())
			return new ModelAndView("RegistrationPage");
		userAccount=userServices.acceptUserDetails(userAccount);
		userAccount.setPassword(userServices.encryptPassword(password));
		return new ModelAndView("RegistrationSuccessPage","userAccount",userAccount);
	} 

	@RequestMapping("/loginUser")
	public ModelAndView logInForUser( HttpSession session,@RequestParam String emailId, String password) throws InvalidPasswordException,UserNotFoundException {
		if(userServices.loginService(emailId, password)!=null) {
			session.setAttribute("emailId", emailId);
		}
		else throw new UserNotFoundException();
		
		return new ModelAndView("userProfilePage", "userAccount", userServices.loginService(emailId, password));
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
	public ModelAndView changePassword(@RequestParam String emailId,
			@RequestParam String oldPassword, @RequestParam String newPassword) throws InvalidPasswordException,UserNotFoundException {
		userServices.changePassword(emailId,oldPassword, newPassword);
		return new ModelAndView("changePasswordSuccessPage", "UserAccount", "password Changed Successfully");

	} 

	@RequestMapping("/updateUser")
	public ModelAndView updateUser(@Valid @ModelAttribute UserAccount userAccount,String emailId,BindingResult result) throws EmailAlreadyExistException, UserNotFoundException {
		if(result.hasErrors())
			return new ModelAndView("AccountSettingsPage");
		userAccount=userServices.updateUserDetails(userAccount,emailId);
		return new ModelAndView("AccountSettingsPageSuccess","userAccount",userAccount);
	}


	@RequestMapping("/logoutUser")
	public ModelAndView registerUser(@Valid @ModelAttribute UserAccount userAccount, BindingResult result, ModelMap model) throws EmailAlreadyExistException {
		if(result.hasErrors())
			return new ModelAndView("userProfilePage");
		userServices.userLogout();
		return new ModelAndView("LogoutSuccessPage","userAccount",null);
	}

	@RequestMapping("/saveImage")
	public ModelAndView profilePic(@RequestParam MultipartFile profilePictureFile, HttpSession session) throws UserNotFoundException {

		return new ModelAndView("userProfilePage", "userAccount", userServices.addPhoto((String) session.getAttribute("emailId"), profilePictureFile));		
	}


	@RequestMapping("/updatePost")
	public ModelAndView updatePost(@RequestParam String postMessage, HttpSession session)  throws InvalidEmailException,UserNotFoundException {
		UserAccount userAccount=userServices.findAccountByEmailId((String)session.getAttribute("emailId"));
		postServices.savePost((String)session.getAttribute("emailId"), postMessage);
		List<Post> posts=postServices.ShowAllPosts(userAccount.getEmailId());
		return new ModelAndView("userProfilePage", "posts", posts);
	}
	@RequestMapping("/showAllPosts")
	public ModelAndView showAllPosts(HttpSession session) throws InvalidEmailException,UserNotFoundException {
		UserAccount userAccount=userServices.findAccountByEmailId((String)session.getAttribute("emailId"));
		List<Post> posts=postServices.ShowAllPosts(userAccount.getEmailId());
		return new ModelAndView("userProfilePage", "posts", posts);
	}


}
