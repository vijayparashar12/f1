package com.vp.f1;

public class F1Car extends Car{
	private static final float HANDLING_FACTOR = 0.8f;

	public F1Car(int topSpeed, float acceleration) {
		this.topSpeed = topSpeed;
		this.acceleration = acceleration;
	}

	/* (non-Javadoc)
	 * @see com.vp.f1.Car#currentSpeed(int)
	 */
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

	/* (non-Javadoc)
	 * @see com.vp.f1.Car#doBreak()
	 */
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