package com.ssafy.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@GetMapping("/rest")
	public String rest() {
		return "REST 데이터입니다!";
	}

}
