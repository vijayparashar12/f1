package com.vp.f1;

public class Team {
	private static final int ACELERATION_FACTOR = 2;
	private static final int TOP_SPEED_FACTOR = 10;
	private static final int DEFAULT_TOP_SPEED = 150;

	private Driver driver;
	private int index;
	//private Track track;

	public Team(int index, Track track) {
		this.index = index;
		//this.track = track;
		Car car = new Car(DEFAULT_TOP_SPEED + TOP_SPEED_FACTOR * index, ACELERATION_FACTOR * index);
		String driverName = "Driver" + index;
		driver = new Driver(driverName,index, car,track);
	}

	public Driver getDriver() {
		return driver;
	}

	public int getIndex() {
		return index;
	}
	
	public float getCurrentPosition(int time){
		return driver.getCurrentPosition(time);
	}

}
