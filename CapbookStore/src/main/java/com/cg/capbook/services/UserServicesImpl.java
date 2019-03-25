package com.cg.capbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.UserLogin;
import com.cg.capbook.dao.UserDAO;
import com.cg.capbook.exceptions.EmailAlreadyExistException;
import com.cg.capbook.exceptions.UserNotFoundException;

@Component("userServices")
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserDAO userDao;
	private UserAccount userAccount = new UserAccount();
	
	@Override
	public UserAccount acceptUserDetails(UserAccount user) {
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
	public UserAccount getUserDetails(String emailId) throws UserNotFoundException {
		return userDao.findById(emailId).orElseThrow(()->new UserNotFoundException("user not found"));
	}

	public UserAccount validateUser(UserLogin login) {
	    return userDao.findById(login.getEmailId()).get();
	  }

	@Override
	public UserAccount findAccountByEmailId(String emailId) throws UserNotFoundException {

		return userDao.findById(emailId).orElseThrow(()->new UserNotFoundException("user not found"));
	}
	
	
}
