package com.cg.capbook.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.capbook.beans.UserAccount;
import com.cg.capbook.beans.UserPhoto;

public interface PostPhoto extends JpaRepository<UserPhoto, Integer> {

}
