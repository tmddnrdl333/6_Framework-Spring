package com.ssafy.myapp.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.myapp.model.dto.Dept;


@Mapper
public interface DeptDAO {


	boolean insertDept(Dept dept) ;

	Dept selectDept(int deptNo) ;
	Dept selectDeptWithEmpList(int deptNo) ;

	List<Dept> selectDeptList() ;

	boolean deleteDept(int deptNo) ;

	boolean updateDept(Dept dept) ;

	// 부서이름을 이용하여 포함검색한 부서리스트 리턴
	List<Dept> selectDeptListByName(String dName) ;
	// 검색 조건에 따른 부서리스트 리턴
	List<Dept> selectDeptListByCondition(Map<String,String> condition) ;
	

}