package com.vp.agoda;

public class Car {
	private static final float HANDLING_FACTOR = 0.8f;

	private int topSpeed;
	private float acceleration;
	private float speed;

	public Car(int topSpeed, float acceleration) {
		this.topSpeed = topSpeed;
		this.acceleration = acceleration;
	}

	public float currentSpeed(int time) {
		speed = speed + acceleration * time;
		topSpeedCheck();
		return speed;
	}

	private void topSpeedCheck() {
		if (speed > topSpeed) {
			speed = topSpeed;
		}
	}

	public float doBreak() {
		speed = speed * HANDLING_FACTOR;
		topSpeedCheck();
		return speed;
	}

	public float nitro() {
		speed = speed * 2;
		topSpeedCheck();
		return speed;
	}
}
