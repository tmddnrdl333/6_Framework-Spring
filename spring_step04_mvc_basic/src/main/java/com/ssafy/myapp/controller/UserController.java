package com.ssafy.myapp.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.myapp.model.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {

	UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/login.do")
	private String login(@RequestParam String id, @RequestParam String pass, HttpSession session, Model model)
			throws Exception {
		String[] info = userService.login(id, pass);
		if (info != null) {
			session.setAttribute("userId", id);
			session.setAttribute("userName", info[0]);
			session.setAttribute("userProfile", info[1]);
			return "redirect:/";
		} else {
			model.addAttribute("errorMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			return "/login";
		}
	}

	@GetMapping("/logout.do")
	private String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/";
	}

	@PostMapping("/modify_profile.do")
	public String modifyProfile(@RequestParam MultipartFile profile, HttpSession session) throws Exception {
		String userId = (String) session.getAttribute("userId");
		String realPath = session.getServletContext().getRealPath("/resources/img/profile");
		String fileName = userId + profile.getOriginalFilename().substring(profile.getOriginalFilename().indexOf("."));
		File dest = new File(realPath + File.separator + fileName);
		profile.transferTo(dest);

		userService.modifyProfile(userId, fileName);
		session.setAttribute("userProfile", fileName);
		return "redirect:/";
	}

}
