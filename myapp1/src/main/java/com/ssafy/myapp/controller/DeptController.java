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

@RequestMapping("/api/depts")
//@Controller
//@ResponseBody // 두개를 합친게 RestController
@RestController
public class DeptController {

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
	public ResponseEntity<List<Dept>> searchDept(@RequestParam(required = false) String dName,
			@RequestParam(required = false) String loc) {
		HashMap<String, String> condition = new HashMap<>();
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
//		return ResponseEntity.ok().build();
		return ResponseEntity.created(URI.create("/api/depts/" + dept.getDeptNo())).build();
	}

	@GetMapping("/{deptNo}")
	private ResponseEntity<Dept> deptDetail(@PathVariable int deptNo) { // 리턴타입의 제네릭은 사실 없에도 됨. 성공했을 때의 기준으로 타입을 넣어준 것일
																		// 뿐. 없으면 노란줄이 뜨지만 괜찮.
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

}
