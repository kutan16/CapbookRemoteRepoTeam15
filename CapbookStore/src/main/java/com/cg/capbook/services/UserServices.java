package com.cg.capbook.services;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.exceptions.EmailAlreadyExistException;

public interface UserServices {
	UserAccount acceptUserDetails(UserAccount user) throws EmailAlreadyExistException;
	boolean removeUserDetails(String emailId);
	boolean CheckUserDetails(String emailId) throws EmailAlreadyExistException;
}
