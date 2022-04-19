package com.ssafy.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.myapp.model.dto.PageInfo;
import com.ssafy.myapp.model.service.UserService;

public class UserController {

	UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PageInfo process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subUrl = request.getServletPath().substring(5);
		if (subUrl.equals("/login.do")) {
			return login(request, response);
		} else if (subUrl.equals("/logout.do")) {
			return logout(request, response);
		} else if (subUrl.equals("/login_form.do")) {
			return loginForm(request, response);
		}
		return null;
	}

	private PageInfo login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		try {
			String name = userService.login(id, pass);
			if (name != null) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", id);
				session.setAttribute("userName", name);
				return new PageInfo(false, "/index.jsp");
			} else {
				request.setAttribute("errorMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
				return new PageInfo(true, "/login.jsp");
			}
		} catch (Exception e) {
			request.setAttribute("errorMsg", "로그인 실행 중 문제가 발생하였습니다.");
			throw e;
		}
	}

	private PageInfo logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().invalidate();
		return new PageInfo(false, "/index.jsp");
	}

	private PageInfo loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo(true, "/login.jsp");
	}

}
