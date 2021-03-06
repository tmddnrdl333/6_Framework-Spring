package com.ssafy.step03.setter.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Scope("prototype")
@Service("greeting")
public class GreetingServiceKo implements GreetingService {

	private OutputService outputter = null; // 의존객체를 담을 멤버변수 선언

	public GreetingServiceKo() {
		System.out.println("GreetingServiceKo()...");
	}

	@Autowired
	public void setOutputter(OutputService outputter) { // 의존객체를 받아들일 setter 작성
		this.outputter = outputter;
		System.out.println("setOutputter()...");
	}

	public void sayHello(String name) {
		outputter.output("하이 " + name);
	}
}
