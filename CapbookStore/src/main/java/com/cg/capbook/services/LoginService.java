package com.cg.capbook.services;

import com.cg.capbook.beans.UserLogin;

public interface LoginService {
	Boolean checkUser(UserLogin login);
}
