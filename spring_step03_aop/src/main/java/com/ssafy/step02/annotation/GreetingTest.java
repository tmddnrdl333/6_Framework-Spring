package com.ssafy.step02.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetingTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {

		ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("beans2.xml");

		GreetingService bean = container.getBean("greeting", GreetingService.class);
		System.out.println(bean.getClass().getName());
		bean.sayHello("김재환");
//		bean.sayHello(null);
		bean.sayGoodbye();

//		public void com.ssafy.step01.xml.GreetingServiceKo.sayHello(java.lang.String)
//		public void com.ssafy.step01.xml.GreetingServiceKo.sayGoodbye()
//		System.out.println(bean.getClass().getMethod("sayHello", String.class).toString());
//		System.out.println(bean.getClass().getMethod("sayGoodbye").toString());
	}
}
