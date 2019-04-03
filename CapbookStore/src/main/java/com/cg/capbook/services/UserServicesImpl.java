package com.cg.capbook.services;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.UserData;
import com.cg.capbook.beans.UserStatus;
import com.cg.capbook.dao.StatusDao;
import com.cg.capbook.dao.UserDAO;
import com.cg.capbook.exceptions.EmailAlreadyExistException;
import com.cg.capbook.exceptions.EmptyStatusException;
import com.cg.capbook.exceptions.InvalidPasswordException;
import com.cg.capbook.exceptions.UserNotFoundException;

@Component("userServices")
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserDAO userDao;
	@Autowired
	private StatusDao statusDao;
	
	private UserAccount userAccount = new UserAccount();
	private UserStatus userStatus = new UserStatus();
	private UserData userData = new UserData();
	private  static String imageLocation ="C:\\Users\\ADM-IG-HWDLAB1D\\git\\CapbookRemoteRepoTeam15\\CapbookStore\\src\\main\\resources\\static\\images\\";

	@Override
	public UserAccount acceptUserDetails(UserAccount user) {
		user =  userDao.save(user);
		user.setPassword(encryptPassword(user.getPassword()));
		return userDao.save(user);
	}

	@Override
	public boolean removeUserDetails(String emailId) {
		userDao.deleteById(emailId);
		return true;
	}

	@Override
	public boolean CheckUserDetails(String emailId) throws EmailAlreadyExistException {
		if(emailId==userAccount.getEmailId())
			throw new EmailAlreadyExistException();
		return true;
	}

	@Override
	public UserAccount findAccountByEmailId(String emailId) throws UserNotFoundException {
		return userDao.findById(emailId).orElseThrow(()->new UserNotFoundException("user not found"));
	}

	@Override
	public Boolean userLogout() {
		userAccount.setEmailId(null);
		return true;
	}

	@Override
	public UserAccount updateUserDetails(UserAccount user ,String emailId ) throws UserNotFoundException {
		
		UserAccount userAccount = findAccountByEmailId(emailId);
		userAccount.setAddress(user.getAddress());
		userAccount.setCity(user.getCity());
		userAccount.setEducation(user.getEducation());
		userAccount.setHobbies(user.getHobbies());
		userAccount.setState(user.getState());
//		userAccount.setData(user);
		return userDao.save(userAccount);
	}
	@Override
	public UserAccount addPhoto(String emailId, MultipartFile file) throws UserNotFoundException {
		UserAccount userAccount = findAccountByEmailId(emailId);
		try {
			Path path = Paths.get(imageLocation + file.getOriginalFilename());
			file.transferTo(path);
			userAccount.setProfilePictureFile("/images/" + file.getOriginalFilename());
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return userDao.save(userAccount);
	}
	
	@Override
	public String encryptPassword(String password) {
		String result = "";
		int s = 4;
		for (int i=0; i<password.length(); i++) 
		{ 
			if (Character.isUpperCase(password.charAt(i))) 
			{ 
				char ch = (char)(((int)password.charAt(i) + 
						s - 65) % 26 + 65); 
				result+=ch;
			} 
			else
			{ 
				char ch = (char)(((int)password.charAt(i) + 
						s - 97) % 26 + 97); 
				result+=ch; 
			} 
		}  
		userAccount.setPassword(result);
		return result; 
	}

	@Override
	public UserAccount loginService(String emailId, String password) throws InvalidPasswordException, UserNotFoundException {
		UserAccount userAccount = findAccountByEmailId(emailId);
		if(!userAccount.getPassword().equals(encryptPassword(password))) 
			throw new InvalidPasswordException("Invalid password or Email");
		return userAccount;
	}

//	@Override
//	public boolean saveStatus(UserStatus status) throws UserNotFoundException, EmptyStatusException {
//		statusDao.save(status);
//		return false;
//	}

	@Override
	public boolean saveStatus(String emailId, UserStatus status) throws UserNotFoundException, EmptyStatusException {
		userAccount = findAccountByEmailId(emailId);
		
		if(statusDao.save(status)== null)
			throw new EmptyStatusException("please enter status");
		
		statusDao.save(status);
		return true;
	}

	@Override
	public boolean changePassword(String emailId, String oldPassword, String newPassword)
			throws UserNotFoundException, InvalidPasswordException {
		UserAccount userAccount = findAccountByEmailId(emailId);
		if(userAccount.getPassword().equals(encryptPassword(oldPassword)))
		{
			userAccount.setPassword(encryptPassword(newPassword));
		userDao.save(userAccount);
		return true;
		}
		else throw new InvalidPasswordException("You have entered inccorect old password");
	}
	
	@Override
	public UserAccount findAccountByEmailIdForSearch(String emailId) {
		return userDao.findById(emailId).orElse(null);
	}

//	@Override
//	public boolean saveStatus(String emailId, UserStatus status) throws UserNotFoundException, EmptyStatusException {
//		userAccount = fi
//		
//		return true;
//	}
//
//
////		public boolean saveStatus(UserStatus status) {
////			if(statusDao.save(status)== null) {
////				return true;
////			}
////			return false;
////			
////		}
}
