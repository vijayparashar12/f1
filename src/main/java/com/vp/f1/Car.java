package com.vp.f1;

public abstract class Car {

	protected int topSpeed;
	protected float acceleration;
	protected float speed;

	public abstract float currentSpeed(int time);

	public abstract float doBreak();

}