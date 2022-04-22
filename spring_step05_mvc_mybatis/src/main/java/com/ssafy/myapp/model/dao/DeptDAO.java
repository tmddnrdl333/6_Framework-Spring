package com.ssafy.myapp.model.dao;

import java.util.List;

import com.ssafy.myapp.model.dto.Dept;

public interface DeptDAO {

	boolean insertDept(Dept dept);

	Dept selectDept(int deptNo);

	List<Dept> selectDeptList();

	boolean deleteDept(int deptNo);

	boolean updateDept(Dept dept);

	// 부서이름을 이용하여 포함검색한 부서리스트 리턴
	List<Dept> selectDeptListByName(String dName) ;

}