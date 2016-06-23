package com.vp.f1;

public class F1Car extends Car {
	private boolean nitroExhausted;
	private static final float HANDLING_FACTOR = 0.8f;

	public F1Car(int topSpeed, float acceleration) {
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
		if (!nitroExhausted) {
			speed = speed * 2;
			topSpeedCheck();
			nitroExhausted = true;
		}
		return speed;
	}
}
