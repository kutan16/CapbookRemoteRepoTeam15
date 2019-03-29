package com.cg.capbook.services;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.dao.UserDAO;
import com.cg.capbook.exceptions.EmailAlreadyExistException;
import com.cg.capbook.exceptions.UserNotFoundException;

@Component("userServices")
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserDAO userDao;
	private UserAccount userAccount = new UserAccount();
	private  static String imageLocation ="C:\\Users\\ADM-IG-HWDLAB1D\\git\\CapBookLocalRepoTeam15\\CapBookStore\\src\\main\\resources\\static\\images\\";
	
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

//	public UserAccount validateUser(UserLogin login) {
//	    return userDao.findById(login.getEmailId()).get();
//	  }

	@Override
	public UserAccount findAccountByEmailId(String emailId) throws UserNotFoundException {
		return userDao.findById(emailId).orElseThrow(()->new UserNotFoundException("user not found"));
	}

	@Override
	public UserAccount userLogout() {
		userAccount.setEmailId(null);
		return null;
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
	public String decryptPassword(String password) {
		String result = "";
        int s = 4;
       for (int i=0; i<password.length(); i++) 
       { 
           if (Character.isUpperCase(password.charAt(i))) 
           { 
               char ch = (char)(((int)password.charAt(i) + 
                                 s + 65) % 26 - 65); 
               result+=ch;
           } 
           else
           { 
               char ch = (char)(((int)password.charAt(i) + 
                                 s + 97) % 26 - 97); 
               result+=ch; 
           } 
       }  
       userAccount.setPassword(result);
       return result; 
	}

	@Override
	public boolean validateUser(UserAccount account) {
		account.setPassword(decryptPassword(account.getPassword()));
		if(account!=null && account.getEmailId().equalsIgnoreCase(userAccount.getEmailId()) &&
				account.getPassword().equalsIgnoreCase(userAccount.getPassword()))
			account.setPassword(encryptPassword(account.getPassword()));
		return true;
	}
}
