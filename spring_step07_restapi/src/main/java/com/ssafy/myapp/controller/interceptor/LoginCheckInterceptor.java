package com.ssafy.myapp.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component("loginInterceptor")
@SuppressWarnings("deprecation")
public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");

		if (userId == null) {
			System.out.println("로그인 되어 있지 않음!!!");

			request.setAttribute("errorMsg", "로그인이 필요합니다!!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
			return false;
		}
		return true;
	}

}
