package com.pmdemy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserExamDetails {

	public UserExamDetails() {

	}

	public UserExamDetails(Integer userExamId, Integer qNumber, String givenAnswer, String correctAnswer) {
		super();
		this.userExamId = userExamId;
		this.qNumber = qNumber;
		this.givenAnswer = givenAnswer;
		this.correctAnswer = correctAnswer;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private Integer userExamId;

	private Integer qNumber;

	private String givenAnswer;

	private String correctAnswer;

	public Integer getUserExamId() {
		return userExamId;
	}

	public void setUserExamId(Integer userExamId) {
		this.userExamId = userExamId;
	}

	public Integer getqNumber() {
		return qNumber;
	}

	public void setqNumber(Integer qNumber) {
		this.qNumber = qNumber;
	}

	public String getGivenAnswer() {
		return givenAnswer;
	}

	public void setGivenAnswer(String givenAnswer) {
		this.givenAnswer = givenAnswer;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
