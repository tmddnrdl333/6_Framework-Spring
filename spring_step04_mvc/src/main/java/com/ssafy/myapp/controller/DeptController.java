package com.ssafy.myapp.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
			return deptRestList(request, response); // datainfo 얘만
		} else if (subUrl.equals("/detail.do")) {
			return deptDetail(request, response);
		} else if (subUrl.equals("/rest/detail.do")) {
			return deptRestDetail(request, response);
		} else if (subUrl.equals("/regist.do")) {
			return deptRegist(request, response);
		} else if (subUrl.equals("/regist_form.do")) {
			return deptRegistForm(request, response);
		} else if (subUrl.equals("/modify.do")) {
			return deptModify(request, response);
		} else if (subUrl.equals("/modify_form.do")) {
			return deptModifyForm(request, response);
		} else if (subUrl.equals("/remove.do")) {
			return deptRemove(request, response);
		}
		return null;
	}

	private DataInfo deptRestDetail(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		return new DataInfo("application/json;charset=utf-8", deptService.getDept(deptNo));
	}

	private DataInfo deptRestList(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		return new DataInfo("application/json;charset=utf-8", deptService.getDeptList());
	}

	@GetMapping("/dept/list.do")
	private String deptList(Model model) throws Exception {
		try {
			List<Dept> list = deptService.getDeptList();
			model.addAttribute("deptList", list);

			return "/dept/list";
		} catch (SQLException e) {
			e.printStackTrace();
			// 에러페이지로 이동 =>
			model.addAttribute("errorMsg", "부서 목록조회에 실패했습니다.");
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
			// 에러페이지로 이동
			request.setAttribute("errorMsg", "부서 상세조회에 실패했습니다.");
			throw e;
		}
	}

	private PageInfo deptRegist(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		String dName = request.getParameter("dName");
		String loc = request.getParameter("loc");

		try {
			deptService.registDept(new Dept(deptNo, dName, loc));
			// 성공페이지로 이동 => 부서 목록으로 이동 (부서목록 조회하는 컨트롤러로 이동)
			return new PageInfo(false, "/dept/list.do");
		} catch (Exception e) {
			// 에러페이지로 이동 =>
			request.setAttribute("errorMsg", "부서 등록에 실패했습니다.");
			throw e;
		}
	}

	private PageInfo deptRegistForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new PageInfo(true, "/dept/regist.jsp");
	}

	private PageInfo deptModifyForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		try {
			Dept dept = deptService.getDept(deptNo);
			request.setAttribute("dept", dept);

			return new PageInfo(true, "/dept/modify.jsp");
		} catch (SQLException e) {
			// 에러페이지로 이동
			request.setAttribute("errorMsg", "부서 상세조회에 실패했습니다.");
			throw e;
		}

	}

	private PageInfo deptModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		String dName = request.getParameter("dName");
		String loc = request.getParameter("loc");
		try {
			deptService.modifyDept(new Dept(deptNo, dName, loc));
			// 성공페이지로 이동 => 부서 목록으로 이동 (부서목록 조회하는 컨트롤러로 이동)
			return new PageInfo(false, "/dept/list.do");
		} catch (Exception e) {
			// 에러페이지로 이동 =>
			request.setAttribute("errorMsg", "부서 수정에 실패했습니다.");
			throw e;
		}
	}

	private PageInfo deptRemove(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int deptNo = Integer.parseInt(request.getParameter("deptNo"));
		try {
			deptService.removeDept(deptNo);
			// 성공페이지로 이동 => 부서 목록으로 이동 (부서목록 조회하는 컨트롤러로 이동)
			return new PageInfo(false, "/dept/list.do");
		} catch (Exception e) {
			// 에러페이지로 이동 =>
			request.setAttribute("errorMsg", "부서 삭제에 실패했습니다.");
			throw e;
		}
	}
}
