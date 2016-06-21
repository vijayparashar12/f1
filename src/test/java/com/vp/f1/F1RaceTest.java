package com.vp.f1;

import static org.junit.Assert.*;

import org.junit.Test;

import com.vp.f1.Race;
import com.vp.f1.Track;

public class F1RaceTest {

	@Test
	public void lastDriverTest() {
		StubTrack track = new StubTrack(1000, 3);
		float[] d = { 100f, 200f, 300f };
		track.setDistanceArray(d);
		assertFalse(track.amITheLastDriver(2));
		assertTrue(track.amITheLastDriver(1));
	}

	@Test
	public void ifCarHasSomeOtherCarWithDistanceOf10MetersThanItHasNeighbour() throws Exception {
		StubTrack track = new StubTrack(1000, 3);
		float[] d = { 100f, 108f, 300f };
		track.setDistanceArray(d);
		assertFalse(track.hasNeighbour(3));
		assertTrue(track.hasNeighbour(1));
		assertTrue(track.hasNeighbour(2));
	}

	@Test
	public void getWinnerIndexTest() throws Exception {
		StubTrack track = new StubTrack(1000, 3);
		float[] d = { 100f, 200f, 300f };
		track.setDistanceArray(d);
		assertEquals(track.getLeadingTeamIndex(), 2);
	}

	@Test
	public void ifDistanceOfLeadingTeamIsMoreThanTrackLengthThanShowCheckedFlag() throws Exception {
		StubTrack track = new StubTrack(1000, 3);
		float[] d = { 900f, 820f, 1000f };
		track.setDistanceArray(d);
		assertTrue(track.showCheckedFlag());
	}

	@Test
	public void validateWinner() throws Exception {
		Race f1Race = new Race(1000, 3);
		f1Race.start();
		assertEquals(f1Race.getWinner().getIndex(), 3);

	}

	@Test
	public void smallRace() throws Exception {
		Race f1Race5Team = new Race(100, 10);
		f1Race5Team.start();
		assertEquals(f1Race5Team.getWinner().getIndex(), 1);
	}

	/**
	 * Track class is stubbed to get access of distance field.
	 * 
	 * @author vijay
	 */
	class StubTrack extends Track {

		public StubTrack(int length, int noOfTeams) {
			super(length, noOfTeams);
		}

		public void setDistanceArray(float[] d) {
			distance = d;
		}

	}

}
