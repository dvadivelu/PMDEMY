package com.pmdemy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmdemy.domain.UserExamDetails;
import com.pmdemy.repo.UserExamDetailsRepository;

@Service
public class UserExamDetailsService {
	
	
	@Autowired
	public UserExamDetailsRepository userExamDetailsRepository;
	
	public UserExamDetailsService(UserExamDetailsRepository userExamDetailsRepository) {
		this.userExamDetailsRepository =  userExamDetailsRepository;
	}
	
	
	public UserExamDetails saveUserExamDetails(UserExamDetails userExamDetails) {
		return userExamDetailsRepository.save(userExamDetails);
	}

}
