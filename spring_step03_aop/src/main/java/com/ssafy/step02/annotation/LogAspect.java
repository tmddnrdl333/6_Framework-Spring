package com.ssafy.step02.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	@Before("execution(public void com.ssafy.step02..GreetingService.sayHello(java.lang.String))")
	public void beforeLogging(JoinPoint joinPoint) {
		System.out.println("----" + joinPoint.getSignature().getName() + " 메소드 호출 전...");
		System.out.println("----매개변수 : " + joinPoint.getArgs()[0]);
		if(joinPoint.getArgs()[0]==null) {
			throw new IllegalArgumentException("매개변수가 null일 수는 없습니다.");
		}
	}

	public void afterLogging() {
		System.out.println("메소드 호출 후(정상실행 후)...");
	}

}
