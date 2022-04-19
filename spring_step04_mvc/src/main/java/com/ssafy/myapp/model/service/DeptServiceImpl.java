package com.ssafy.myapp.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.myapp.model.dao.DeptDAO;
import com.ssafy.myapp.model.dto.Dept;

@Service
public class DeptServiceImpl implements DeptService {

	private DeptDAO deptDao;
	
	@Autowired
	public void setDeptDao(DeptDAO deptDao) {
		this.deptDao = deptDao;
	}

	// 원래는 사용자정의 예외를 만들어서 throw해줘야 controller에서 catch해서 처리해주는 방법을 쓰는 게 좋음.
	@Override
	public boolean registDept(Dept dept) throws SQLException {
		if (getDept(dept.getDeptno()) != null) {
			throw new IllegalArgumentException("이미 등록된 부서입니다.");
		}
		return deptDao.insertDept(dept);
	}

	@Override
	public boolean modifyDept(Dept dept) throws SQLException {
		if (getDept(dept.getDeptno()) == null) {
			throw new IllegalArgumentException("등록된 부서가 없습니다.");
		}
		return deptDao.updateDept(dept);
	}

	@Override
	public boolean removeDept(int deptNo) throws SQLException {
		if (getDept(deptNo) == null) {
			throw new IllegalArgumentException("등록된 부서가 없습니다.");
		}
		return deptDao.deleteDept(deptNo);
	}

	@Override
	public Dept getDept(int deptNo) throws SQLException {
		return deptDao.selectDept(deptNo);
	}

	@Override
	public List<Dept> getDeptList() throws SQLException {
		return deptDao.selectDeptList();
	}

	@Override
	public List<Dept> getDeptListByName(String dName) throws SQLException {
		return deptDao.selectDeptListByName(dName);
	}

}
