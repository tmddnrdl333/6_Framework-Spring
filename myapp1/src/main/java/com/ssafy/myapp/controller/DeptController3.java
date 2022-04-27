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
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myapp.model.dto.Dept;
import com.ssafy.myapp.model.service.DeptService;

@RequestMapping("/api/depts")
//@Controller
//@ResponseBody // 두개를 합친게 RestController
//@RestController
public class DeptController3 {

	private DeptService deptService;

	@Autowired
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}

// @GetMapping
//	private List<Dept> deptRestList() {
//		return deptService.getDeptList();
//	}

	@GetMapping
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
	private boolean deptRegist(@RequestBody Dept dept) {
		return deptService.registDept(dept);
	}

	@GetMapping("/{deptNo}")
	private Dept deptDetail(@PathVariable int deptNo) {
		return deptService.getDept(deptNo);
	}

	@DeleteMapping("/{deptNo}")
	public boolean removeDept(@PathVariable int deptNo) {
		return deptService.removeDept(deptNo);
	}

	@PutMapping("/{deptNo}")
	public boolean modifyDept(@PathVariable int deptNo, @RequestBody Dept dept) {
		return deptService.modifyDept(dept);
	}

}
