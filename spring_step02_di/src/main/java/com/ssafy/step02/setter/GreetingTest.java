package com.ssafy.step02.setter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {
	
	public static void main(String[] args) {

		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("beans2.xml");

		GreetingService bean = container.getBean("greeting", GreetingService.class);
		bean.sayHello("이동욱");
		bean.sayHello("김재환");
		bean.sayHello("정해인");
	}
}
