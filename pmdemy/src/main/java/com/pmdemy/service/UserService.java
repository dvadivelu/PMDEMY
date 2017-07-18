package com.pmdemy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pmdemy.domain.UserMaster;
import com.pmdemy.repo.UserRespository;

@Service
public class UserService {

	private UserRespository userRespository;
	
	public UserService() {
		
	}
	
	@Autowired
	public UserService(UserRespository userRespository) {
		this.userRespository = userRespository;
	}
	
	public UserMaster createUser(UserMaster userMaster) {
		if (findUser(userMaster.getEmail())==null) {
			//userMaster.setPassword( new BCryptPasswordEncoder().encode(userMaster.getPassword()));
			return userRespository.save(userMaster);
		}
		return null;
	}
	
	
	public boolean validateUser(UserMaster userMaster) {
		UserMaster userFromDB = findUser(userMaster.getEmail());
		//userMaster.setPassword( new BCryptPasswordEncoder().encode(userMaster.getPassword()));
		boolean retVal = false;
		if(userFromDB == null) {
			retVal = false;
		}else {
			retVal = userMaster.getPassword().equals(userFromDB.getPassword());
		}
		return retVal;
		}
	
	public UserMaster findUser(String email) {
		return userRespository.findByEmail(email);
	}
}
