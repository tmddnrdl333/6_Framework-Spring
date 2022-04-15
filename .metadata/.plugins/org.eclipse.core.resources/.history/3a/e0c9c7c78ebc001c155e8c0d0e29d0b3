package com.ssafy.step01.xml;

import org.aspectj.lang.JoinPoint;

public class LogAspect {

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
