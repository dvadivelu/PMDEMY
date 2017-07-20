package com.pmdemy.domain;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserExam {
	
	public UserExam() {
		
	}

	public UserExam(Integer userId, Integer examId, Date examStart, Date examEnd, Integer totalQuestions,
			Integer totalCorrectAnswers) {
		super();
		this.userId = userId;
		this.examId = examId;
		this.examStart = examStart;
		this.examEnd = examEnd;
		this.totalQuestions = totalQuestions;
		this.totalCorrectAnswers = totalCorrectAnswers;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Integer userId;
	
	private Integer examId;
	
	private Date examStart;
	
	private Date examEnd;
	
	private Integer totalQuestions;
	
	private Integer totalCorrectAnswers;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public Date getExamStart() {
		return examStart;
	}

	public void setExamStart(Date examStart) {
		this.examStart = examStart;
	}

	public Date getExamEnd() {
		return examEnd;
	}

	public void setExamEnd(Date examEnd) {
		this.examEnd = examEnd;
	}

	public Integer getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(Integer totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public Integer getTotalCorrectAnswers() {
		return totalCorrectAnswers;
	}

	public void setTotalCorrectAnswers(Integer totalCorrectAnswers) {
		this.totalCorrectAnswers = totalCorrectAnswers;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
