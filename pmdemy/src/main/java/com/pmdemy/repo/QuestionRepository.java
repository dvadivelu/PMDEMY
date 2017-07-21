package com.pmdemy.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.pmdemy.domain.DifficultyLevel;
import com.pmdemy.domain.QuestionMaster;

public interface QuestionRepository extends PagingAndSortingRepository<QuestionMaster, Integer> {

	public QuestionMaster findByQNumber(Integer qNUmber);

	public Iterable<QuestionMaster> findByDifficultyLevel(DifficultyLevel difficultyLevel) ;

}
