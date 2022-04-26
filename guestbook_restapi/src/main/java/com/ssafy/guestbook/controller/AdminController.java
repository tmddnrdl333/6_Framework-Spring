package com.ssafy.guestbook.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

//	@RequestMapping(value = "/user", method = RequestMethod.GET, headers = { "Content-type=application/json" })
////	@ResponseBody ????
//	public List<MemberDto> userList() throws Exception {
////		List<MemberDto> list = memberService.listMember();
//		return memberService.listMember();
//	}
//
//	@RequestMapping(value = "/user", method = RequestMethod.POST, headers = { "Content-type=application/json" })
//	public List<MemberDto> userRegister(@RequestBody MemberDto memberDto) throws Exception {
//		memberService.registerMember(memberDto);
//		return memberService.listMember();
//	}
//
//	@RequestMapping(value = "/user/{userid}", method = RequestMethod.GET, headers = { "Content-type=application/json" })
//	public MemberDto userInfo(@PathVariable("userid") String userid) throws Exception {
//		return memberService.getMember(userid);
//	}
//
//	@RequestMapping(value = "/user", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
//	public List<MemberDto> userModify(@RequestBody MemberDto memberDto) throws Exception {
//		memberService.updateMember(memberDto);
//		return memberService.listMember();
//	}
//
//	@RequestMapping(value = "/user/{userid}", method = RequestMethod.DELETE, headers = {
//			"Content-type=application/json" })
//	public List<MemberDto> userDelete(@PathVariable("userid") String userid) throws Exception {
//		memberService.deleteMember(userid);
//		return memberService.listMember();
//	}

	@GetMapping("/user")
	public ResponseEntity<?> userList() throws Exception {
		List<MemberDto> list = memberService.listMember();
		if (list != null && !list.isEmpty()) {
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
//			return new ResponseEntity<String>("에러 : 서버에서 에러 발생!!", HttpStatus.INTERNAL_SERVER_ERROR);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping("/user")
	public ResponseEntity<?> userRegister(@RequestBody MemberDto memberDto) throws Exception {
		memberService.registerMember(memberDto);
		return new ResponseEntity<List<MemberDto>>(memberService.listMember(), HttpStatus.OK);
	}

	@GetMapping("/user/{userid}")
	public ResponseEntity<?> userInfo(@PathVariable("userid") String userid) throws Exception {
		MemberDto memberDto = memberService.getMember(userid);
		if (memberDto != null) {
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
	}

	@PutMapping("/user")
	public ResponseEntity<?> userModify(@RequestBody MemberDto memberDto) throws Exception {
		memberService.updateMember(memberDto);
		return new ResponseEntity<List<MemberDto>>(memberService.listMember(), HttpStatus.OK);
//		int cnt = memberService.updateMember(memberDto);
//		return new ResponseEntity<Integer>(cnt, HttpStatus.CREATED);
	}

	@DeleteMapping("/user/{userid}")
	public ResponseEntity<?> userDelete(@PathVariable("userid") String userid) throws Exception {
		memberService.deleteMember(userid);
		return new ResponseEntity<List<MemberDto>>(memberService.listMember(), HttpStatus.OK);
	}

}
