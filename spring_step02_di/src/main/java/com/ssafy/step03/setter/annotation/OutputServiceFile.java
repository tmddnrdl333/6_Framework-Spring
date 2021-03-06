package com.ssafy.step03.setter.annotation;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Component;

@Component("outputterFile")
public class OutputServiceFile implements OutputService {

	@Override
	public void output(String msg) {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileWriter("msg.log", true));
			out.println(msg);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null)
				out.close();
		}
	}
}
