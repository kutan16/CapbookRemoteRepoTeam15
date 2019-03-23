package com.cg.capbook.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.UserLogin;
import com.cg.capbook.dao.LoginDAO;
import com.cg.capbook.dao.UserDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDAO userDao;

	@Override
	public Boolean checkUser(String emailId,String password) {

		List<UserAccount> users= userDao.findAll();

		for(UserAccount user:users) {
			if(user.getEmailId().equals(emailId)) {
				if(user.getPassword().equals(password)) {
						return true;
					}
				}
			}
		return false;
	}
}
