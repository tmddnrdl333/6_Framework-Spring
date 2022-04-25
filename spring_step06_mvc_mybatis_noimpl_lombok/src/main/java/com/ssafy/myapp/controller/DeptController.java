package com.ssafy.myapp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.myapp.model.dto.Dept;
import com.ssafy.myapp.model.service.DeptService;

@RequestMapping("/dept")
@Controller
public class DeptController {

	private DeptService deptService;

	@Autowired
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

	@GetMapping("/rest/list")
	@ResponseBody
	private List<Dept> deptRestList() {
		return deptService.getDeptList();
	}

//	@RequestMapping(value = "/list.do", method = RequestMethod.GET)
	@GetMapping("/list.do")
	private String deptList(Model model) {
		List<Dept> list = deptService.getDeptList();
		model.addAttribute("deptList", list);

		return "/dept/list";
	}

	@GetMapping("/detail.do")
	private String deptDetail(@RequestParam("deptNo") int deptNo, Model model) {
		Dept dept = deptService.getDept(deptNo);
		model.addAttribute("dept", dept);
		return "/dept/detail";
	}

	@GetMapping("/rest/detail/{deptNo}")
	@ResponseBody
	private Dept deptRestDetail(@PathVariable int deptNo) {
		return deptService.getDept(deptNo);
	}

	@PostMapping("/regist.do")
	private String deptRegist(Dept dept, Model model) {
		deptService.registDept(dept);
		// 성공페이지로 이동==> 부서 목록으로 이동(부서목록 조회하는 컨트롤러 이동)
		return "redirect:/dept/list.do";
	}

	@PostMapping("/auth/remove.do")
	public String removeDept(@RequestParam int deptNo) {
		deptService.removeDept(deptNo);
		return "redirect:/dept/list.do";
	}

	@PostMapping("/auth/modify.do")
	public String modifyDept(Dept dept) {
		deptService.modifyDept(dept);
		return "redirect:/dept/list.do";
	}

	@PostMapping("/search")
	public String searchDept(@RequestParam Map<String, String> condition, Model model) {
		model.addAttribute("deptList", deptService.searchDeptList(condition));
		return "/dept/list";
	}

}
