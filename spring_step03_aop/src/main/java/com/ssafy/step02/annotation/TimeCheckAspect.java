package com.ssafy.step02.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeCheckAspect {

	@Pointcut("execution(* com.ssafy..*(..))")
	public void ssafyPointCut() {}

	@Around("ssafyPointCut()")
	public Object checkTime(ProceedingJoinPoint joinPoint) {

		Object o = null;
		try {
			// before
			long start = System.nanoTime();
			o = joinPoint.proceed();
			// after returning
			long end = System.nanoTime();
			System.out.println(" # " + joinPoint.getSignature().getName() + " 메소드 수행시간 : " + (end - start) + "ns");
		} catch (Throwable e) {
			// after throwing
			e.printStackTrace();
		} finally {
			// after
		}
		return o;
	}
}
