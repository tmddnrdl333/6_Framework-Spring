package com.ssafy.myapp.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.myapp.model.dto.Dept;

public interface DeptService {

	boolean registDept(Dept dept);

	boolean modifyDept(Dept dept);

	boolean removeDept(int deptNo);

	Dept getDept(int deptNo);

	List<Dept> getDeptList();

	List<Dept> getDeptListByName(String dName);

	List<Dept> searchDeptList(Map<String, String> condition);

}