package com.cg.capbook.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.capbook.beans.UserLogin;
import com.cg.capbook.dao.LoginDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDao;

	@Override
	public Boolean checkUser(UserLogin login) {

		List<UserLogin> users= loginDao.findAll();

		for(UserLogin user:users) {
			if(user.getEmailId().equals(login.getEmailId())) {
				if(user.getPassword().equals(login.getPassword())) {
						return true;
					}
				}
			}
		return false;
	}
}
