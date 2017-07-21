package com.pmdemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pmdemy.domain.ExamMaster;
import com.pmdemy.service.ExamService;

@Controller
public class ExamController {

	@Autowired
	private ExamService examService = null;

	public ExamController(ExamService examService) {
		this.examService = examService;
	}

	@RequestMapping("/exam")
	public String loadExam(Model model) {
		model.addAttribute("exams", examService.lookUp());
		return "exam";
	}

	@RequestMapping("/elookup")
	public Iterable<ExamMaster> greeetUser() {
		return examService.lookUp();
	}

	@RequestMapping("/startExam")
	public String startExam(@RequestParam(value = "examId") String examId, @RequestParam(value = "pageNum") int pageNum , Model model) {
		model.addAttribute("exam", examService.findByExamId("dinesh.vadivelu@gmail.com", examId, new PageRequest(pageNum, 1)));
		model.addAttribute("name", "Dinesh");
		return "finalexam";
	}
}
