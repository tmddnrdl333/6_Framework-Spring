package com.ssafy.step03.setter.annotation;

import org.springframework.stereotype.Component;

@Component("outputter")
public class OutputServiceConsole implements OutputService {

	@Override
	public void output(String msg) {
		System.out.println(msg);
	}
}
