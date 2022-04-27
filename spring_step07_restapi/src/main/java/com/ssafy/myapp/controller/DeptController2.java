package com.ssafy.myapp.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.myapp.model.dto.Dept;
import com.ssafy.myapp.model.service.DeptService;

@RequestMapping("/api/depts")
//@Controller
public class DeptController2 {

	private DeptService deptService;

	@Autowired
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

//	@GetMapping
//	@ResponseBody
//	private List<Dept> deptRestList() {
//		return deptService.getDeptList();
//	}

	@GetMapping
	@ResponseBody
	public List<Dept> searchDept(@RequestParam(required = false) String dName,
			@RequestParam(required = false) String loc) {
		HashMap<String, String> condition = new HashMap<>();
		if (dName != null)
			condition.put("dName", dName);
		if (loc != null)
			condition.put("loc", loc);
		return deptService.searchDeptList(condition);
	}

	@PostMapping
	@ResponseBody
	private boolean deptRegist(@RequestBody Dept dept) {
		return deptService.registDept(dept);
	}

	@GetMapping("/{deptNo}")
	@ResponseBody
	private Dept deptDetail(@PathVariable int deptNo) {
		return deptService.getDept(deptNo);
	}

	@DeleteMapping("/{deptNo}")
	@ResponseBody
	public boolean removeDept(@PathVariable int deptNo) {
		return deptService.removeDept(deptNo);
	}

	@PutMapping("/{deptNo}")
	@ResponseBody
	public boolean modifyDept(@PathVariable int deptNo, @RequestBody Dept dept) {
		return deptService.modifyDept(dept);
	}

}
