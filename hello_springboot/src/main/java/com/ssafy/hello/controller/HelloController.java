package com.ssafy.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping("/home")
	public String index() {
		return "home";
	}
	
}
