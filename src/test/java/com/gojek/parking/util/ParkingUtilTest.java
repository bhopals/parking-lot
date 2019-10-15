package com.gojek.parking.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParkingUtilTest {

	@Test
	public void isNullOrEmptyStringTest(){
		assertEquals(true, ParkingUtil.isNullOrEmptyString(null));
		assertEquals(true, ParkingUtil.isNullOrEmptyString(""));
		assertEquals(true, ParkingUtil.isNullOrEmptyString("  "));
		assertEquals(false, ParkingUtil.isNullOrEmptyString("T  Dd"));
		assertEquals(false, ParkingUtil.isNullOrEmptyString("TEST"));
	}
}
