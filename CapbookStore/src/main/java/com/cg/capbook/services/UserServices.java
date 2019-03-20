package com.cg.capbook.services;

import com.cg.capbook.beans.UserAccount;

public interface UserServices {
	UserAccount acceptUserDetails(UserAccount user);
	boolean removeUserDetails(String emailId);
	
}
