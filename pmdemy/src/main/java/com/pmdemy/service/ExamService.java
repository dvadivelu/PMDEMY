package com.pmdemy.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pmdemy.domain.ExamMaster;
import com.pmdemy.domain.QuestionMaster;
import com.pmdemy.domain.UserExam;
import com.pmdemy.domain.UserExamDetails;
import com.pmdemy.domain.UserMaster;
import com.pmdemy.repo.ExamRepository;

@Service
public class ExamService {

	@Autowired
	private ExamRepository examRepository;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserExamService userExamService;

	@Autowired
	private UserExamDetailsService userExamDetailsService;

	@Autowired
	private UserService userService;

	public ExamService() {

	}

	public QuestionMaster createExam(ExamMaster examMaster) {
		if (examMaster.getId() == null || !examRepository.exists(examMaster.getId())) {
			examRepository.save(examMaster);
		}
		return null;
	}

	public Iterable<ExamMaster> lookUp() {
		return examRepository.findAll();
	}

	public QuestionMaster findByExamId(String userId, String examId, Pageable pageable) {
		ExamMaster examMaster = examRepository.findByExamId(examId);
		UserMaster userMaster = userService.findUser(userId);
		Iterable<QuestionMaster> qMasters = null;
		List<QuestionMaster> eQuestion = null;
		QuestionMaster retQMater = null;
		if (userMaster != null) {
			UserExam userExam = new UserExam();
			userExam.setUserId(userMaster.getId());
			userExam.setExamId(examMaster.getId());
			Iterable<UserExam> userExams = userExamService.findByUserIdAndExamId(userExam);
			if (!userExams.iterator().hasNext()) {
				UserExam uExam = new UserExam();
				uExam.setExamStart(new Date(System.currentTimeMillis()));
				uExam.setExamId(examMaster.getId());
				userExamService.saveUserExam(uExam);
				java.util.List<UserExam> list = new ArrayList<UserExam>();
				list.add(uExam);
				userExams = list;
			}
			for (UserExam exam : userExams) {
				if (exam.getExamEnd() == null) {
					qMasters = questionService.findByDifficultyLevel(examMaster.getDifficultyLevel());
					for (QuestionMaster qMaster : qMasters) {
						UserExamDetails userExamDetails = new UserExamDetails();
						userExamDetails.setqNumber(qMaster.getqNumber());
						userExamDetails.setCorrectAnswer(qMaster.getCorrectAnswer());
						userExamDetails.setUserExamId(exam.getExamId());
						userExamDetailsService.saveUserExamDetails(userExamDetails);
					}

				}

			}
			eQuestion = questionService.findByDifficultyLevel(examMaster.getDifficultyLevel(),pageable);
			if(eQuestion!=null && eQuestion.size()>0) {
				retQMater = eQuestion.get(0);
			}
		}
		return retQMater;
	}

}
