package com.pmdemy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmdemy.domain.ExamMaster;
import com.pmdemy.domain.QuestionMaster;
import com.pmdemy.repo.ExamRepository;

@Service
public class ExamService {

	private ExamRepository examRepository;

	@Autowired
	public ExamService(ExamRepository examRepository) {
		this.examRepository = examRepository;
	}

	public QuestionMaster createExam(ExamMaster examMaster) {
		if (examMaster.getId()==null || !examRepository.exists(examMaster.getId())) {
			examRepository.save(examMaster);
		}
		return null;
	}

	public Iterable<ExamMaster> lookUp() {
		return examRepository.findAll();
	}

}
