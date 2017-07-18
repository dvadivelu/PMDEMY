package com.pmdemy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	
	@RequestMapping("/")
	public String landingPage() {
		return "index";
	}

}
