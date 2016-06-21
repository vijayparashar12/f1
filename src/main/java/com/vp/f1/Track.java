package com.vp.f1;

public class Track {
	private int length;
	protected float[] distance;

	public Track(int length, int noOfTeams) {
		this.length = length;
		distance = new float[noOfTeams];
		updateStartPosition(noOfTeams);
	}

	private void updateStartPosition(int noOfTeams) {
		for (int i = 0; i < noOfTeams; i++) {
			distance[i] = -(i * 200);
		}
	}

	public boolean showCheckedFlag() {
		return length <= maxDistanceCovered();
	}

	private float maxDistanceCovered() {
		float max = 0;
		for (int i = 0; i < distance.length; i++) {
			if (max < distance[i]) {
				max = distance[i];
			}
		}
		return max;
	}

	public float getDistanceCovered(int teamIndex) {
		return distance[teamIndex - 1];
	}

	public boolean hasNeighbour(int teamIndex) {
		boolean hasNeighbour = false;
		float teamLocation = distance[teamIndex - 1];
		for (int i = 0; i < distance.length; i++) {
			if (i == teamIndex - 1) {
				continue;
			}
			if (absoluteDistance(teamLocation, distance[i]) < 10) {
				hasNeighbour = true;
				break;
			}
		}
		return hasNeighbour;
	}

	private float absoluteDistance(float myCar, float otherCar) {
		float diffrence = otherCar - myCar;
		return diffrence > 0 ? diffrence : diffrence * -1;
	}

	public void updateDistanceCovered(Team team, int time) {
		float currentPosition = team.getCurrentPosition(time);
		distance[team.getIndex() - 1] = currentPosition;
	}

	public int getLeadingTeamIndex() {
		float max = 0;
		int index = 0;
		for (int i = 0; i < distance.length; i++) {
			if (max < distance[i]) {
				max = distance[i];
				index = i;
			}
		}
		return index;
	}

	public boolean amITheLastDriver(int teamIndex) {
		boolean amITheLastDriver = true;
		float teamLocation = distance[teamIndex - 1];
		for (int i = 0; i < distance.length; i++) {
			if (i == teamIndex - 1) {
				continue;
			}
			if (distance[i] < teamLocation) {
				amITheLastDriver = false;
				break;
			}
		}
		return amITheLastDriver;
	}

}
