package com.ssafy.myapp.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ssafy.myapp.model.dto.DataInfo;
import com.ssafy.myapp.model.dto.Dept;
import com.ssafy.myapp.model.dto.PageInfo;
import com.ssafy.myapp.model.service.DeptService;

@Controller
public class DeptController {

	private DeptService deptService;

	@Autowired
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	public Object process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String subUrl = request.getServletPath().substring(5);
		if (subUrl.equals("/rest/list.do")) {
			return deptRestList(request, response); // DataInfo
		} else if (subUrl.equals("/detail.do")) {
			return deptDetail(request, response);
		} else if (subUrl.equals("/rest/detail.do")) {
			return deptRestDetail(request, response);
		}
		return null;
	}

	private DataInfo deptRestList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new DataInfo("application/json;charset=utf-8", deptService.getDeptList());
	}

//	@RequestMapping(value = "/dept/list.do", method = RequestMethod.GET)
	@GetMapping("/dept/list.do")
	private String deptList(Model model) throws Exception {
		try {
			List<Dept> list = deptService.getDeptList();
			model.addAttribute("deptList", list);

			return "/dept/list";
		} catch (SQLException e) {
			model.addAttribute("errorMsg", "부서 목록조회에 실패하였습니다.");
			throw e;
		}
	}

	private PageInfo deptDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		try {
			Dept dept = deptService.getDept(deptNo);
			request.setAttribute("dept", dept);
			return new PageInfo(true, "/dept/detail.jsp");
		} catch (SQLException e) {
			request.setAttribute("errorMsg", "부서 상세조회에 실패하였습니다.");
			throw e;
		}
	}

	private DataInfo deptRestDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		return new DataInfo("application/json;charset=utf-8", deptService.getDept(deptNo));
	}

	@PostMapping("/dept/regist.do")
	private String deptRegist(HttpServletRequest request) throws Exception {
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		String dName = request.getParameter("dName");
		String loc = request.getParameter("loc");

		try {
			deptService.registDept(new Dept(deptNo, dName, loc));
			// 성공페이지로 이동==> 부서 목록으로 이동(부서목록 조회하는 컨트롤러 이동)
			return "redirect:/dept/list.do";
		} catch (Exception e) {
			request.setAttribute("errorMsg", "부서 등록에 실패하였습니다.");
			throw e;
		}
	}

	@GetMapping("/dept/regist_form.do")
	private String deptRegistForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/dept/regist";
	}

}
