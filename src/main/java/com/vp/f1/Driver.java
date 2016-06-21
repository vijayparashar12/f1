package com.vp.f1;

public class Driver {
	private String name;
	private F1Car car;
	private Track track;
	private int teamIndex;

	public Driver(String name, int teamIndex, F1Car car, Track track) {
		this.name = name;
		this.teamIndex = teamIndex;
		this.car = car;
		this.track = track;
	}

	public String getName() {
		return name;
	}

	public float getCurrentPosition(int time) {
		float currentSpeed = car.currentSpeed(time);

		if (track.hasNeighbour(teamIndex)) {
			currentSpeed = car.doBreak();
		}

		if (track.amITheLastDriver(teamIndex)) {
			currentSpeed = car.nitro();
		}

		float position = track.getDistanceCovered(teamIndex) + currentSpeed * Race.TIME_INTERVAL;

		return position;
	}
}
