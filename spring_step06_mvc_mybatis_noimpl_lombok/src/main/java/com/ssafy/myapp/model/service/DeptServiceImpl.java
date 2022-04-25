package com.ssafy.myapp.model.service;

import java.util.List;
import java.util.Map;

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

	@Override
	public boolean registDept(Dept dept) {
		if (getDept(dept.getDeptNo()) != null) {
			throw new IllegalArgumentException("이미 등록된 부서입니다.");
		}
		return deptDao.insertDept(dept);
	}

	@Override
	public boolean modifyDept(Dept dept) {
		if (deptDao.selectDept(dept.getDeptNo()) == null) {
			throw new IllegalArgumentException("등록된 부서가 없습니다.");
		}
		return deptDao.updateDept(dept);
	}

	@Override
	public boolean removeDept(int deptNo) {
		if (getDept(deptNo) == null) {
			return false;
		}
		return deptDao.deleteDept(deptNo);
	}

	@Override
	public Dept getDept(int deptNo) {
//		return deptDao.selectDept(deptNo);
		return deptDao.selectDeptWithEmpList(deptNo);
	}

	@Override
	public List<Dept> getDeptList() {
		return deptDao.selectDeptList();
	}

	@Override
	public List<Dept> getDeptListByName(String dName) {
		return deptDao.selectDeptListByName(dName);
	}

	@Override
	public List<Dept> searchDeptList(Map<String, String> condition) {
		return deptDao.selectDeptListByCondition(condition);
	}

}
