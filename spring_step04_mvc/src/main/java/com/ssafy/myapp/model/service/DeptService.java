package com.ssafy.myapp.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.myapp.model.dto.Dept;

public interface DeptService {

	// 원래는 사용자정의 예외를 만들어서 throw해줘야 controller에서 catch해서 처리해주는 방법을 쓰는 게 좋음.
	boolean registDept(Dept dept) throws SQLException;

	boolean modifyDept(Dept dept) throws SQLException;

	boolean removeDept(int deptNo) throws SQLException;

	Dept getDept(int deptNo) throws SQLException;

	List<Dept> getDeptList() throws SQLException;

	List<Dept> getDeptListByName(String dName) throws SQLException;

}