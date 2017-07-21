package com.pmdemy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmdemy.domain.UserExam;
import com.pmdemy.repo.UserExamRepository;

@Service
public class UserExamService {
	
	@Autowired
	private UserExamRepository userExamRepository;


	public UserExamService(UserExamRepository userExamRepository) {
		this.userExamRepository = userExamRepository;
	}
	
	
	public Iterable<UserExam> findByUserIdAndExamId(UserExam userExam){
		return userExamRepository.findByUserIdAndExamId(userExam.getUserId(),userExam.getExamId());
	}
	
	
	public UserExam saveUserExam(UserExam userExam){
		 return userExamRepository.save(userExam);
	}
	
	
	

}
