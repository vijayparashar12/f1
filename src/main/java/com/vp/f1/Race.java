package com.vp.f1;

public class Race {
	public static final int TIME_INTERVAL = 2;
	private Team[] teams;
	private Track track;
	private int finalTime;

	public Race(int length, int noOfTeams) {
		track = new Track(length, noOfTeams);
		teams = new Team[noOfTeams];
		for (int i = 1; i <= noOfTeams; i++) {
			Team team = new Team(i,track);
			teams[i - 1] = team;
		}
	}

	public void start() {
		int time = 0;
		while (!track.showCheckedFlag()) {
			for (int i = 0; i < teams.length; i++) {
				track.updateDistanceCovered(teams[i], time);
			}
			time += TIME_INTERVAL;
		}
		finalTime = time;
	}

	public Team getWinner() {
		return teams[track.getLeadingTeamIndex()];
	}
	
	public int getFinalTime() {
		return finalTime;
	}
}
