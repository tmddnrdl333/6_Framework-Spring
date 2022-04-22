package com.ssafy.myapp.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myapp.model.dto.Dept;

public interface DeptService {

	boolean registDept(Dept dept) throws SQLException;

	boolean modifyDept(Dept dept) throws SQLException;

	boolean removeDept(int deptNo) throws SQLException;

	Dept getDept(int deptNo) throws SQLException;

	List<Dept> getDeptList() throws SQLException;

	List<Dept> getDeptListByName(String dName) throws SQLException;

}