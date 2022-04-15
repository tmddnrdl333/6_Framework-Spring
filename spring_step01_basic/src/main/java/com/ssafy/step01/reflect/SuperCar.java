package com.ssafy.step01.reflect;

public class SuperCar {
	private int distance, speed;

	public SuperCar() {

	}

	public SuperCar(int distance, int speed) {
		super();
		this.distance = distance;
		this.speed = speed;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void boost() {
		System.out.println("부하아앙");
	}

	@Override
	public String toString() {
		return "SuperCar [distance=" + distance + ", speed=" + speed + "]";
	}
}
