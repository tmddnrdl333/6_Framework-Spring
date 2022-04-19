package com.ssafy.myapp.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myapp.model.dto.Dept;

public interface DeptDAO {

	boolean insertDept0(Dept dept) throws SQLException;

	boolean insertDept(Dept dept) throws SQLException;

	Dept selectDept(int deptNo) throws SQLException;

	List<Dept> selectDeptList() throws SQLException;

	boolean deleteDept(int deptNo) throws SQLException;

	boolean updateDept(Dept dept) throws SQLException;

	// 부서이름을 이용하여 포함검색한 부서리스트 리턴
	List<Dept> selectDeptListByName(String dName) throws SQLException;

}