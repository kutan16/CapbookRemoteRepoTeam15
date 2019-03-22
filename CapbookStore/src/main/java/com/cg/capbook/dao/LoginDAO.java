package com.cg.capbook.dao;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.cg.capbook.beans.Login;

@Transactional
public interface LoginDAO extends JpaRepository<Login, String>{
	
	 @Query("from Login  where emailId=:emailId ")
	    public Login findByUsername(@Param("emailId") String emailId);
	 
	 @Query("select l.password from Login l where l.emailId=:emailId")
	 public String getPasswordByEmail(@Param("emailId")String emailId);
	 
	 @Modifying
	 @Query("update Login set password=:password where emailId=:emailId")
	 public Integer saveLoginPassword(@Param("password")String password,@Param("emailId")String emailId);

}
