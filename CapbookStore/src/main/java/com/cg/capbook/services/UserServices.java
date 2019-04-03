package com.cg.capbook.services;

import org.springframework.web.multipart.MultipartFile;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.UserStatus;
import com.cg.capbook.exceptions.EmailAlreadyExistException;
import com.cg.capbook.exceptions.EmptyStatusException;
import com.cg.capbook.exceptions.InvalidPasswordException;
import com.cg.capbook.exceptions.UserNotFoundException;


public interface UserServices {
	UserAccount acceptUserDetails(UserAccount user) throws EmailAlreadyExistException;
	boolean removeUserDetails(String emailId);
	boolean CheckUserDetails(String emailId) throws EmailAlreadyExistException;
//	UserAccount validateUser(UserLogin login);
	UserAccount findAccountByEmailId(String emailId) throws UserNotFoundException;
	Boolean userLogout();
	UserAccount loginService(String emailId, String password) throws InvalidPasswordException, UserNotFoundException;
	String encryptPassword(String password);
//	String decryptPassword(String password);
	UserAccount addPhoto(String emailId, MultipartFile file) throws UserNotFoundException;
	//UserStatus postStatus(String emailId, String status)throws UserNotFoundException,EmptyStatusException;
	boolean saveStatus(String emailId,UserStatus status)throws UserNotFoundException,EmptyStatusException;;
	UserAccount updateUserDetails(UserAccount user, String emailId) throws UserNotFoundException;
	boolean changePassword(String emailId, String oldPassword, String newPassword) throws UserNotFoundException,InvalidPasswordException;
	UserAccount findAccountByEmailIdForSearch(String emailId);

}