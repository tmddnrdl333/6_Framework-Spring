package com.ssafy.step01.reflect;

import java.lang.reflect.Field;
import java.util.Scanner;

public class CarReflectionTest {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String className = sc.next();
		String methodName = sc.next();

		Class c = Class.forName(className);

		Object o1 = c.getDeclaredConstructor().newInstance();
		Object o2 = c.getDeclaredConstructor().newInstance();
		c.getDeclaredMethod(methodName).invoke(o1);

		Field dField = c.getDeclaredField("distance");
		dField.setAccessible(true);
		dField.set(o1, 1000);
		System.out.println(o1);
		System.out.println(o2);

	}
}
