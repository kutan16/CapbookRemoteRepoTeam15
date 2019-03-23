package com.cg.capbook.services;

import com.cg.capbook.beans.UserLogin;

public interface LoginService {
	Boolean checkUser(String emailId,String password);
}
