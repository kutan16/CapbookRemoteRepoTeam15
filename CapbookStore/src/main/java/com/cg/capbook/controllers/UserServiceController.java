
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.cg.capbook.beans.Post;
import com.cg.capbook.beans.Relationship;
import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.UserFriend;
import com.cg.capbook.exceptions.EmailAlreadyExistException;
import com.cg.capbook.exceptions.InvalidEmailException;
import com.cg.capbook.exceptions.InvalidPasswordException;
import com.cg.capbook.exceptions.UserNotFoundException;
import com.cg.capbook.exceptions.UserNotFriendException;
import com.cg.capbook.services.LikesServices;
import com.cg.capbook.services.PostServices;
import com.cg.capbook.services.UserDislikeServices;
import com.cg.capbook.services.UserFriendService;
import com.cg.capbook.services.UserServices;

@Controller
public class UserServiceController {

	@Autowired
	private UserServices userServices;

	@Autowired
	private UserFriendService friendServices;

	@Autowired
	PostServices postServices;
	
	@Autowired
	LikesServices likeServices;
	@Autowired
	UserDislikeServices dislikeServices;

 //-------------------------User Controller---------------------------------------

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

//-------------------------------------POST-------------------------------------------------
	
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
	
//-----------------------------------Like Dislike ------------------------------------------------
	
	@RequestMapping("/updateLikes")
	public ModelAndView updateLikes(@RequestParam int postId,@RequestParam String likedBy,@SessionAttribute("account") UserAccount account,@SessionAttribute("posts") List<Post> posts) throws InvalidEmailException {
		likeServices.updateLikes(postId, likedBy);
		likeServices.getLikesCount(postId);
		posts=postServices.ShowAllPosts(account.getEmailId());
        return new ModelAndView("myWallPage","posts",posts);
	}
	@RequestMapping("/updateDislikes")
	public ModelAndView updateDisLikes(@RequestParam int postId,@RequestParam String dislikedBy,@SessionAttribute("account") UserAccount account,@SessionAttribute("posts") List<Post> posts) throws InvalidEmailException {
		dislikeServices.updateDislikes(postId, dislikedBy);
		dislikeServices.getDislikesCount(postId);
		posts=postServices.ShowAllPosts(account.getEmailId());
        return new ModelAndView("myWallPage","posts",posts);
	}

//-----------------------------------FRIEND Controller--------------------------------------------
	@RequestMapping("/friendtoUserHome")
	public ModelAndView friendtoUserHome(@SessionAttribute("account") UserAccount account)throws InvalidEmailException, UserNotFriendException{
		return new ModelAndView("userProfilePage", "account",account);
	}
	@RequestMapping("/friendtoUserHomemyStatus")
	public ModelAndView friendtoUserHomemyStatus(@SessionAttribute("account") UserAccount account)throws InvalidEmailException, UserNotFriendException{
		return new ModelAndView("myStatusPage", "account",account);
	}
	@RequestMapping("/friendtoUserHomecheckMails")
	public ModelAndView friendtoUserHomecheckMails(@SessionAttribute("account") UserAccount account)throws InvalidEmailException, UserNotFriendException{
		return new ModelAndView("emailPage", "account",account);
	}
	@RequestMapping("/showAllFriendRequests")
	public ModelAndView showFriendRequests(@SessionAttribute("account") UserAccount account)throws InvalidEmailException, UserNotFriendException{
		List<Relationship> allfriendRequests=friendServices.showAllFriendRequests(account.getEmailId());
		if(allfriendRequests==null)
			return new ModelAndView("allFriendRequestPage", "allfriendRequests","You have no friend requests");
		else
			return new ModelAndView("allFriendRequestPage", "allfriendRequests",allfriendRequests);
	}
	@RequestMapping("/getFriendProfile")
	public ModelAndView getFriendProfile(@SessionAttribute("account") UserAccount account,@RequestParam String friendProfileId)throws InvalidEmailException, UserNotFriendException, UserNotFoundException{
		UserAccount friendProfileAccount=userServices.findAccountByEmailId(friendProfileId);
		return new ModelAndView("friendProfilePage", "friendaccount",friendProfileAccount);
	}
	@RequestMapping("/acceptFriendRequest")
	public ModelAndView acceptFriendRequest(@SessionAttribute("account") UserAccount account,@RequestParam String senderId)throws InvalidEmailException, UserNotFriendException, UserNotFoundException{
		friendServices.confirmFriendRequest(senderId, account.getEmailId());
		List<Relationship> allfriendRequests=friendServices.showAllFriendRequests(account.getEmailId());
		return new ModelAndView("allFriendRequestPage", "allfriendRequests",allfriendRequests);
	}
	@RequestMapping("/rejectFriendRequest")
	public ModelAndView rejectFriendRequest(@SessionAttribute("account") UserAccount account,@RequestParam String senderId)throws InvalidEmailException, UserNotFriendException{
		friendServices.rejectFriendRequest(senderId, account.getEmailId());
		List<Relationship> allfriendRequests=friendServices.showAllFriendRequests(account.getEmailId());
		return new ModelAndView("allFriendRequestPage", "allfriendRequests",allfriendRequests);
	}
	@RequestMapping("/showAllFriends")
	public ModelAndView showAllFriends(@SessionAttribute("account") UserAccount account)throws InvalidEmailException, UserNotFriendException{
		List<UserFriend> allfriends=friendServices.showAllFriends(account.getEmailId());
		return new ModelAndView("allFriendsPage", "allfriends",allfriends);
	}
	@RequestMapping("/sendFriendRequest")
	public ModelAndView sendFriendRequest(@RequestParam String receiverId,@ModelAttribute UserAccount account)throws InvalidEmailException, UserNotFriendException, UserNotFoundException{	
		if(account.getEmailId().equalsIgnoreCase(receiverId)) {
			return new ModelAndView("SearchResultPage", "status", "Cant Send Friend Request to Yourself");
		}
		else {
			Relationship relation=friendServices.findFriendRequest(account.getEmailId(), receiverId);
			if(relation==null) {
				friendServices.sendFriendRequest(account.getEmailId(), receiverId);
				return new ModelAndView("SearchResultPage", "status", "Friend request Sent");
			}
			else {
				if(relation.getStatus().equalsIgnoreCase("pending"))
					return new ModelAndView("SearchResultPage", "status", "Friend Request has already been sent");
				if(relation.getStatus().equalsIgnoreCase("rejected"))
					return new ModelAndView("SearchResultPage", "status", "Sorry that user has rejected your request aldready.");
				else
					return new ModelAndView("SearchResultPage", "status", "User already a friend");
			}
		}
	}
	@RequestMapping("/getSearchResults")
	public ModelAndView getSearchResults(@RequestParam String receiverId,@ModelAttribute UserAccount account)throws InvalidEmailException, UserNotFriendException{	
		UserAccount account1=userServices.findAccountByEmailIdForSearch(receiverId);	
		if(account1==null)
			return new ModelAndView("SearchResultPage", "searchResult","No User Found");
		else
			return new ModelAndView("SearchResultPage", "searchResult",receiverId);

	}	
}
