package com.ssafy.myapp.model.dto;

import java.util.List;

public class Dept {

	private int deptNo;
	private String dName;
	private String loc;
	private List<Emp> empList; // 1 대 다의 관계성을 표현
	
	public Dept() {
		super();
	}
	public Dept(int deptNo, String dName, String loc) {
		super();
		this.deptNo = deptNo;
		this.dName = dName;
		this.loc = loc;
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

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}
	public List<Emp> getEmpList() {
		return empList;
	}
}
