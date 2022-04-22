package com.ssafy.hw0420.controller;

import java.util.Map;

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
	public String login(@RequestParam Map<String, String> userinfo, Model model, HttpSession session) {
		String name = userService.login(userinfo);
		if (name != null) {
			session.setAttribute("userId", userinfo.get("id"));
			session.setAttribute("userName", name);
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			return "/";
		}
	}

	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
