package com.pmdemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmdemy.domain.ExamMaster;
import com.pmdemy.service.ExamService;

@RestController
public class ExamController {

	@Autowired
	private ExamService examService = null;

	public ExamController(ExamService examService) {
		this.examService = examService;
	}

	@RequestMapping("/elookup")
	public Iterable<ExamMaster> greeetUser() {
		return examService.lookUp();
	}

}
