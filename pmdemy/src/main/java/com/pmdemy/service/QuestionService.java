package com.pmdemy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pmdemy.domain.DifficultyLevel;
import com.pmdemy.domain.QuestionMaster;
import com.pmdemy.repo.QuestionRepository;

@Service
public class QuestionService {

	private QuestionRepository questionRepository;

	@Autowired
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	
	public QuestionMaster createQuestion(QuestionMaster question) {
		if (question.getId()==null || !questionRepository.exists(question.getId())) {
			questionRepository.save(question);
		}
		return null;
	}
	
	public Iterable<QuestionMaster> lookUp() {
		return questionRepository.findAll();
	}
	
	public Page<QuestionMaster> listAllByPage(Pageable pageable){
		return questionRepository.findAll(pageable);
	}
	
	public QuestionMaster findByQNumber(Integer qNUmber) {
		return questionRepository.findByQNumber(qNUmber);
	}

	public Iterable<QuestionMaster> findByDifficultyLevel(DifficultyLevel difficultyLevel) {
		return questionRepository.findByDifficultyLevel(difficultyLevel);
	}
	
	public List<QuestionMaster> findByDifficultyLevel(DifficultyLevel difficultyLevel, Pageable pageable) {
		return questionRepository.findByDifficultyLevel(difficultyLevel, pageable);
	}

}
