package com.cg.capbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capbook.beans.UserAccount;

public interface UserDAO extends JpaRepository<UserAccount, String>{

}
