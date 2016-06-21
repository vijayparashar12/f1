package com.vp.f1;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarTest {

	@Test
	public void speedTest() {
		F1Car f1Car = new F1Car(100, 10);
		float speedAfter5Sec = f1Car.currentSpeed(5);
		assertEquals(50, speedAfter5Sec,0.00001);
	}
	
	@Test
	public void speedTestWithTopSpeed() {
		F1Car f1Car = new F1Car(100, 10);
		float speedAfter5Sec = f1Car.currentSpeed(20);
		assertEquals(100, speedAfter5Sec,0.00001);
	}
	
	@Test
	public void breakTest() throws Exception {
		F1Car f1Car = new F1Car(100, 10);
		f1Car.currentSpeed(5);
		float speedAfterBreak = f1Car.doBreak();
		assertEquals(40, speedAfterBreak,0.00001);
	}
	
	@Test
	public void nitroTest() throws Exception {
		F1Car f1Car = new F1Car(100, 10);
		f1Car.currentSpeed(5);
		float speedAfterNitro = f1Car.nitro();
		assertEquals(100, speedAfterNitro,0.00001);
	}
	
	@Test
	public void nitroTestWithTopSpeedLimit() throws Exception {
		F1Car f1Car = new F1Car(100, 10);
		f1Car.currentSpeed(6);
		float speedAfterNitro = f1Car.nitro();
		assertEquals(100, speedAfterNitro,0.00001);
	}

}
