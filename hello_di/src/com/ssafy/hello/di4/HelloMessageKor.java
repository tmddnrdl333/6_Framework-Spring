package com.ssafy.hello.di4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "kor")
public class HelloMessageKor implements HelloMessage {

	@Autowired
	private TestDao dao;

//	public void setDao(TestDao dao) {
//		System.out.println("setDao 호출햇당");
//		this.dao = dao;
//	}

	public HelloMessageKor() {
		System.out.println("HelloMessageKor Contructor Call!!!!!!!!!");
	}

	public String hello(String name) {
		name = dao.getName();
		return "안녕하세요 " + name;
	}

}
