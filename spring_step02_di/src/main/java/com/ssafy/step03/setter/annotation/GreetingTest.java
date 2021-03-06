package com.ssafy.step03.setter.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("beans3.xml");

		GreetingService bean = container.getBean("greeting", GreetingService.class);
		GreetingService bean2 = container.getBean("greeting", GreetingService.class);
		bean.sayHello("이동욱");
		bean.sayHello("김재환");
		bean.sayHello("정해인");

		System.out.println(bean == bean2); // 싱글톤인지 확인 - 맞앙
	}
}
