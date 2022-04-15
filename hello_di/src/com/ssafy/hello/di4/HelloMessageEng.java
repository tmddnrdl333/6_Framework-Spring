package com.ssafy.hello.di4;

import org.springframework.stereotype.Service;

@Service
public class HelloMessageEng implements HelloMessage {

	public HelloMessageEng() {
		System.out.println("HelloMessageEng Contructor Call!!!!!!!!!");
	}

	public String hello(String name) {
		return "Hello " + name;
	}

}
