package com.ssafy.step01.constructor;

public class GreetingServiceKo implements GreetingService {

	private OutputService outputter = null; // 의존객체를 담을 멤버변수 선언

	public GreetingServiceKo(OutputService outputter) { // 의존객체를 받아들일 생성자 작성
		super();
		this.outputter = outputter;
		System.out.println("GreetingServiceKo()...");
	}

	public void sayHello(String name) {
		outputter.output("하이 " + name);
	}
}
