package com.pmdemy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmdemy.domain.UserMaster;
import com.pmdemy.repo.UserRespository;

@Service
public class UserService {

	private UserRespository userRespository;
	
	@Autowired
	public UserService(UserRespository userRespository) {
		this.userRespository = userRespository;
	}
	
	public UserMaster createUser(UserMaster userMaster) {
		if (findUser(userMaster.getEmail())==null) {
			userRespository.save(userMaster);
		}
		return null;
	}
	
	
	public UserMaster findUser(String email) {
		return userRespository.findByEmail(email);
	}
}
