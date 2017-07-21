package com.pmdemy.repo;

import org.springframework.data.repository.CrudRepository;

import com.pmdemy.domain.ExamMaster;

public interface ExamRepository extends CrudRepository<ExamMaster, Integer> {

	public ExamMaster findByExamId(String examId);
}
