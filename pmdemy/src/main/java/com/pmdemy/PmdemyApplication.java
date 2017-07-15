package com.pmdemy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pmdemy.domain.DifficultyLevel;
import com.pmdemy.domain.ExamMaster;
import com.pmdemy.domain.QuestionMaster;
import com.pmdemy.service.ExamService;
import com.pmdemy.service.QuestionService;

@SpringBootApplication
public class PmdemyApplication implements CommandLineRunner {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private ExamService examService;

	public static void main(String[] args) {
		SpringApplication.run(PmdemyApplication.class, args);
	}

	
	@Override
	public void run(String... arg0) throws Exception {
		List<String> list = new ArrayList<String>();
		list.add("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magn..");
		list.add("eger tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat..");
		list.add("t a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutzie ");
		list.add("ucibus. Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis");
		list.add("mpus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante");
		list.add("et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis");
		list.add("adipiscing sem neque sed ipsum. Nam quam nunc, blandit vel, luctus pulvinar, hendrerit id, lorem. Maecenas nec odio et ante");
		list.add("Duis leo. Sed fringilla mauris sit amet nibh. Donec et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis");

		for (int i = 1; i <= 50; i++) {
			questionService.createQuestion(new QuestionMaster(i, list.get(new Random().nextInt(7)), "Answer1", "Answer2", "Answer3",
					"Answer4", "Answer"+new Random().nextInt(5), DifficultyLevel.Level0));
			questionService.createQuestion(new QuestionMaster(i, list.get(new Random().nextInt(7)), "Answer1", "Answer2", "Answer3",
					"Answer4", "Answer"+new Random().nextInt(5), DifficultyLevel.Level1));
			questionService.createQuestion(new QuestionMaster(i, list.get(new Random().nextInt(7)), "Answer1", "Answer2", "Answer3",
					"Answer4", "Answer"+new Random().nextInt(5), DifficultyLevel.Level2));
			questionService.createQuestion(new QuestionMaster(i, list.get(new Random().nextInt(7)), "Answer1", "Answer2", "Answer3",
					"Answer4", "Answer"+new Random().nextInt(5), DifficultyLevel.Level3));
			questionService.createQuestion(new QuestionMaster(i, list.get(new Random().nextInt(7)), "Answer1", "Answer2", "Answer3",
					"Answer4", "Answer"+new Random().nextInt(5), DifficultyLevel.Level4));
			questionService.createQuestion(new QuestionMaster(i, list.get(new Random().nextInt(7)), "Answer1", "Answer2", "Answer3",
					"Answer4", "Answer"+new Random().nextInt(5), DifficultyLevel.Level5));
		}

		 	examService.createExam(new ExamMaster("Exam Neque porro", "E0000", DifficultyLevel.Level0));
		 	examService.createExam(new ExamMaster("Exam quisquam", "E0001", DifficultyLevel.Level1));
		 	examService.createExam(new ExamMaster("Exam dolorem", "E0002", DifficultyLevel.Level2));
		 	examService.createExam(new ExamMaster("Exam consectetur porro", "E0003", DifficultyLevel.Level3));
		 	examService.createExam(new ExamMaster("Exam adipisci porro", "E0004", DifficultyLevel.Level4));
		 	examService.createExam(new ExamMaster("Exam velit porro", "E0005", DifficultyLevel.Level5));

	

	}
}
