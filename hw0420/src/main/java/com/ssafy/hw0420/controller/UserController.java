package com.ssafy.hw0420.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.hw0420.model.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {

	UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/login.do")
	public String login(@RequestParam String id, @RequestParam String pass, Model model, HttpSession session)
			throws Exception {
		String name = userService.login(id, pass);
		if (name != null) {
			session.setAttribute("userId", id);
			session.setAttribute("userName", name);
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			System.out.println("HELLO");
			return "/";
		}
	}

	@GetMapping("/logout.do")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}

}
