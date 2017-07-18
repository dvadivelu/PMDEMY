package com.pmdemy.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping("/create")
	public String createUser(
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "email", required = true) String email) {
		String viewStr = null;
		UserMaster userMaster = userService.createUser(new UserMaster("", password, email));
		if (userMaster == null) {
			viewStr = "index";
		} else {
			viewStr = "home";
		}
		return viewStr;
	}

	@RequestMapping("/login")
	public String loginUser(@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "password", required = true) String password) {
		String view = "";
		if (userService.validateUser(new UserMaster("", password, email))) {
			view = "home";
		} else {
			view = "index";
		}
		return view;
	}
}
