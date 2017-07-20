package com.pmdemy.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pmdemy.domain.UserExam;

public interface UserExamRepository extends CrudRepository<UserExam, Integer> {

	List<UserExam> findByUserId(String userId);
}
