package com.ssafy.step01.xml;

public class GreetingServiceKo implements GreetingService {

	public void sayHello(String name) {
		System.out.println("안농하세요 " + name);
	}

	@Override
	public void sayGoodbye() {
		System.out.println("뱌뱌~~");
	}

}
