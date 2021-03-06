package com.ssafy.step01.xml;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimeCheckAspect {
	public Object checkTime(ProceedingJoinPoint joinPoint) {

		Object o = null;
		try {
			// before
			long start = System.nanoTime();
			o = joinPoint.proceed();
			// after returning
			long end = System.nanoTime();
			System.out.println(" # "+joinPoint.getSignature().getName() + " 메소드 수행시간 : " + (end - start) + "ns");
		} catch (Throwable e) {
			// after throwing
			e.printStackTrace();
		} finally {
			// after
		}
		return o;
	}
}
