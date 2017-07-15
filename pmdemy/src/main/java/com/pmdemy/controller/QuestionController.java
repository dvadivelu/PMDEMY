package com.pmdemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pmdemy.domain.QuestionMaster;
import com.pmdemy.service.QuestionService;

@RestController
public class QuestionController {

	
	@Autowired
	private QuestionService questionService = null;
	
	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	
	@RequestMapping("/qlookup")
	public Iterable<QuestionMaster> greeetUser() {
		return questionService.lookUp();
	}
	
	@RequestMapping("/qlistbypage")
	public Page<QuestionMaster> listAllByPage(Pageable pageable){
		return questionService.listAllByPage(pageable);
	}
	
	@RequestMapping("/question")
	public QuestionMaster findByQuestionNum(@RequestParam(value="qnum", defaultValue="1") Integer qNumber){
		return questionService.findByQNumber(qNumber);
	}
}
