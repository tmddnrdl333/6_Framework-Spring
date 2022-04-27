package com.ssafy.myapp.model.dto;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class Dept {

	private int deptNo;
	private String dName;
	private String loc;
	private List<Emp> empList;

	public Dept() {
		super();
	}

	public Dept(int deptNo, String dName, String loc, List<Emp> empList) {
		super();
		this.deptNo = deptNo;
		this.dName = dName;
		this.loc = loc;
		this.empList = empList;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}

	public String toString() {
		return super.toString();
	}

}
