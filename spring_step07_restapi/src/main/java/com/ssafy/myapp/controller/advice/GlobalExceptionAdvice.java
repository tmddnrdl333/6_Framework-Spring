package com.ssafy.myapp.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionAdvice {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		e.printStackTrace();
		ModelAndView mav = new ModelAndView("error");
		mav.addObject("errorMsg", e.getMessage());
		return mav;
	}

}
