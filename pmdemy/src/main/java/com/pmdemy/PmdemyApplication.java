package com.pmdemy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pmdemy.domain.DifficultyLevel;
import com.pmdemy.domain.QuestionMaster;
import com.pmdemy.service.QuestionService;

@SpringBootApplication
public class PmdemyApplication implements CommandLineRunner{
	
	@Autowired
	private QuestionService questionService;

	public static void main(String[] args) {
		SpringApplication.run(PmdemyApplication.class, args);
	}
	
	
	@Override
	public void run(String... arg0) throws Exception {
		questionService.createQuestion(new QuestionMaster(1,"Question1","Answer1","Answer2","Answer3","Answer4","Answer2", DifficultyLevel.Level0));
		questionService.createQuestion(new QuestionMaster(2,"Question2","Answer1","Answer2","Answer3","Answer4","Answer1", DifficultyLevel.Level2));
		questionService.createQuestion(new QuestionMaster(3,"Question3","Answer1","Answer2","Answer3","Answer4","Answer3", DifficultyLevel.Level3));
		questionService.createQuestion(new QuestionMaster(4,"Question4","Answer1","Answer2","Answer3","Answer4","Answer4", DifficultyLevel.Level4));
		questionService.createQuestion(new QuestionMaster(5,"Question5","Answer1","Answer2","Answer3","Answer4","Answer1", DifficultyLevel.Level5));
		questionService.createQuestion(new QuestionMaster(6,"Question1","Answer1","Answer2","Answer3","Answer4","Answer2", DifficultyLevel.Level1));
 
	}
}
