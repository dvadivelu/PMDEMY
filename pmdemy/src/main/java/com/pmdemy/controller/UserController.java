package com.pmdemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pmdemy.domain.UserMaster;
import com.pmdemy.service.UserService;

@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/login")
	public String loginUser(@RequestParam(value = "name", required = true) String userName,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "email", required = true) String email) {

		userService.createUser(new UserMaster(userName, new BCryptPasswordEncoder().encode(password), email));
		return "home";
	}
}
