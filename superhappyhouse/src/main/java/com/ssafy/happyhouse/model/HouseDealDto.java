package com.ssafy.happyhouse.model;

public class HouseDealDto {
	private int no;
	private int aptCode;
	private String dealAmount;
	private int dealYear;
	private int dealMonth;
	private int dealDay;
	private float area;
	private int floor;
	private int type;
	private int rentMoney;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getAptCode() {
		return aptCode;
	}

	public void setAptCode(int aptCode) {
		this.aptCode = aptCode;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public int getDealYear() {
		return dealYear;
	}

	public void setDealYear(int dealYear) {
		this.dealYear = dealYear;
	}

	public int getDealMonth() {
		return dealMonth;
	}

	public void setDealMonth(int dealMonth) {
		this.dealMonth = dealMonth;
	}

	public int getDealDay() {
		return dealDay;
	}

	public void setDealDay(int dealDay) {
		this.dealDay = dealDay;
	}

	public float getArea() {
		return area;
	}

	public void setArea(float area) {
		this.area = area;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getRentMoney() {
		return rentMoney;
	}

	public void setRentMoney(int rentMoney) {
		this.rentMoney = rentMoney;
	}
}
