package com.pmdemy.repo;

import org.springframework.data.repository.CrudRepository;

import com.pmdemy.domain.UserExam;

public interface UserExamRepository extends CrudRepository<UserExam, Integer> {

	Iterable<UserExam> findByUserIdAndExamId(Integer userId, Integer emailId);
}
