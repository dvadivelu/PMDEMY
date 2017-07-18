package com.pmdemy.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ExamMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String examName;
	private String examId;
	private DifficultyLevel difficultyLevel;

	public ExamMaster() {
		
	}
			
	public ExamMaster(String examName, String examId, DifficultyLevel difficultyLevel) {
		super();
		this.examName = examName;
		this.examId = examId;
		this.difficultyLevel = difficultyLevel;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getExamId() {
		return examId;
	}

	public void setExamId(String examId) {
		this.examId = examId;
	}

	public DifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
