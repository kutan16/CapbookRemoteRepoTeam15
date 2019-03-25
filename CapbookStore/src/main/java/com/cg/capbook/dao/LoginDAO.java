package com.cg.capbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capbook.beans.UserLogin;

public interface LoginDAO extends JpaRepository<UserLogin, String>{
	
}