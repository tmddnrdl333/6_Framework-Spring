package com.ssafy.myapp.model.dto;

import org.springframework.stereotype.Repository;

@Repository
public class Dept {

	private int deptNo;
	private String dName;
	private String loc;

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

	public String toString() {
		return super.toString();
	}

}
