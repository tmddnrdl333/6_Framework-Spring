package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.model.NoticeDto;
import com.ssafy.happyhouse.model.service.NoticeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);

	@Autowired
	private NoticeService noticeService;

	@GetMapping
	public ModelAndView noticeListByCondition(@RequestParam(required = false) String userName,
			@RequestParam(required = false) String subject) throws SQLException {

		HashMap<String, String> condition = new HashMap<String, String>();
		if (userName != null)
			condition.put("userName", userName);
		if (subject != null)
			condition.put("subject", subject);

		List<NoticeDto> list = noticeService.getNoticeListByCondition(condition);
		ModelAndView mav = new ModelAndView();
		mav.addObject(list);
		mav.setViewName("/notice");
		return mav;

	}

	@GetMapping("/{noticeNo}")
	@ResponseBody
	public ResponseEntity<NoticeDto> noticeDetail(@PathVariable int noticeNo) throws SQLException {
		NoticeDto noticeDto = noticeService.getNotice(noticeNo);
		if (noticeDto != null)
			return ResponseEntity.ok(noticeDto);
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{noticeNo}")
	public ResponseEntity removeNotice(@PathVariable int noticeNo) throws SQLException {
		if (noticeService.getNotice(noticeNo) != null) {
			noticeService.removeNotice(noticeNo);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{noticeNo}")
	public ResponseEntity modifyNotice(@PathVariable int noticeNo, @RequestBody NoticeDto noticeDto)
			throws SQLException {
		if (noticeService.getNotice(noticeNo) != null) {
			noticeService.modifyNotice(noticeDto);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
