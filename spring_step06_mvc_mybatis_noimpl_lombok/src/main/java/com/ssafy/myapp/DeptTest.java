package com.ssafy.myapp;

import com.ssafy.myapp.model.dto.Dept;
import com.ssafy.myapp.model.dto.Dept_lombok;

public class DeptTest {

	public static void main(String[] args) {

		Dept_lombok dept = Dept_lombok.builder().deptNo(55).dName("개발8팀").build();
		Dept_lombok dept2 = Dept_lombok.builder().deptNo(55).dName("개발8팀").loc("서울").build();

		System.out.println(dept);
		System.out.println(dept2);

	}
}
