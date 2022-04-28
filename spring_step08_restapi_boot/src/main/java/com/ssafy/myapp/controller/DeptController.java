package com.ssafy.myapp.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.myapp.model.dto.Dept;
import com.ssafy.myapp.model.service.DeptService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("부서 정보 REST API")
@RequestMapping("/api/depts")
//@Controller
//@ResponseBody
@RestController
public class DeptController {

	private DeptService deptService;

	@Autowired
	public void setDeptService(DeptService deptService) {
		this.deptService = deptService;
	}
//	@GetMapping
//	private List<Dept> deptRestList()  {
//		return deptService.getDeptList();
//	}
	
	@ApiOperation("부서리스트를 조회합니다. (부서이름, 지역 정보 전달 가능)")
	@GetMapping
	public ResponseEntity<List<Dept>> searchDept(@RequestParam(required = false) String dName, @RequestParam(required = false) String loc) {

		HashMap<String, String> condition = new HashMap<String, String>();
		if (dName != null)
			condition.put("dName", dName);
		if (loc != null)
			condition.put("loc", loc);

		List<Dept> list = deptService.searchDeptList(condition);
		if (list.size() > 0) {
			return new ResponseEntity<List<Dept>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<List<Dept>>(HttpStatus.NO_CONTENT);
	}

	@PostMapping
	private ResponseEntity deptRegist(@RequestBody Dept dept) {
		deptService.registDept(dept);
		// return ResponseEntity.ok().build();
		return ResponseEntity.created(URI.create("/api/depts/" + dept.getDeptNo())).build();
	}

	@GetMapping("/{deptNo}")
	private ResponseEntity<Dept> deptDetail(@PathVariable int deptNo) {
		Dept dept = deptService.getDept(deptNo);
		if (dept != null) {
			return ResponseEntity.ok(dept);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{deptNo}")
	public ResponseEntity removeDept(@PathVariable int deptNo) {
		if (deptService.getDept(deptNo) != null) {
			deptService.removeDept(deptNo);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{deptNo}")
	public ResponseEntity modifyDept(@PathVariable int deptNo, @RequestBody Dept dept) {
		if (deptService.getDept(deptNo) != null) {
			deptService.modifyDept(dept);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

//	@GetMapping(params = {"dName","loc"})
//	public List<Dept> searchDept(@RequestParam Map<String,String> condition) {
//		return deptService.searchDeptList(condition);
//	}
//	@GetMapping(params = {"dName"})
//	public List<Dept> searchDept2(@RequestParam Map<String,String> condition) {
//		return deptService.searchDeptList(condition);
//	}

}
