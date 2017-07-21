package com.pmdemy.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pmdemy.domain.DifficultyLevel;
import com.pmdemy.domain.QuestionMaster;

public interface QuestionRepository extends PagingAndSortingRepository<QuestionMaster, Integer> {

	public QuestionMaster findByQNumber(Integer qNUmber);

	 
	public List<QuestionMaster> findByDifficultyLevel(DifficultyLevel difficultyLevel,Pageable pagebale) ;
	
	public Iterable<QuestionMaster> findByDifficultyLevel(DifficultyLevel difficultyLevel) ;

}
