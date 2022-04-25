package com.ssafy.guestbook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.guestbook.model.MemberDto;
import com.ssafy.guestbook.model.service.MemberService;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/user", method = RequestMethod.GET, headers = { "Content-type=application/json" })
//	@ResponseBody ????
	public List<MemberDto> userList() throws Exception {
//		List<MemberDto> list = memberService.listMember();
		return memberService.listMember();
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public List<MemberDto> userRegister(@RequestBody MemberDto memberDto) throws Exception {
		return null;
	}

	@RequestMapping(value = "/user/{userid}", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public MemberDto userInfo(@PathVariable("userid") String userid) throws Exception {
		return null;
	}

	@RequestMapping(value = "/user", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	public List<MemberDto> userModify(@RequestBody MemberDto memberDto) throws Exception {
		return null;
	}

	@RequestMapping(value = "/user/{userid}", method = RequestMethod.DELETE, headers = {
			"Content-type=application/json" })
	public List<MemberDto> userDelete(@PathVariable("userid") String userid) throws Exception {
		return null;
	}

}
