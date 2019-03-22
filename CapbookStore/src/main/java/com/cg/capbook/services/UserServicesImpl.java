package com.cg.capbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.dao.UserDAO;
import com.cg.capbook.exceptions.EmailAlreadyExistException;
import com.cg.capbook.exceptions.UserNotFoundException;
@Component("userServices")
public class UserServicesImpl implements UserServices{

	@Autowired
	private UserDAO userDao;
	private UserAccount userAccount = new UserAccount();
	
	@Override
	public UserAccount acceptUserDetails(UserAccount user) {//throws EmailAlreadyExistException {
		//input validation for same emailID
//		CheckUserDetails(userAccount.getEmailId());
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
}
