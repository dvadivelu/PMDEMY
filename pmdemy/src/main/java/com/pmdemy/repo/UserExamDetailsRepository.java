package com.pmdemy.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pmdemy.domain.UserExamDetails;

public interface UserExamDetailsRepository extends CrudRepository<UserExamDetails, Integer> {

	List<UserExamDetails> findByUserExamId(Integer userExamId);
}
