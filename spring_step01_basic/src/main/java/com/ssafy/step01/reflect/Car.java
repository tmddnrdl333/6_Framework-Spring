package com.ssafy.step01.reflect;

public class Car {
	private int distance, speed;

	public Car() {

	}

	public Car(int distance, int speed) {
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

	public void go() {
		System.out.println("띠띠빵빠앙");
	}

	@Override
	public String toString() {
		return "Car [distance=" + distance + ", speed=" + speed + "]";
	}
}
