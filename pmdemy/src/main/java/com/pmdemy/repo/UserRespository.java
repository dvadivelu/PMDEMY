package com.pmdemy.repo;

import org.springframework.data.repository.CrudRepository;

import com.pmdemy.domain.UserMaster;

public interface UserRespository extends CrudRepository<UserMaster, String> {

	public UserMaster findByEmail(String email);
}
