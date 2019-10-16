package com.gojek.parking.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.parking.constant.ParkingConstants;
import com.gojek.parking.service.impl.ParkingServiceImpl;

public class ParkingServiceTest {

	String response = null;
	ParkingService service = ParkingServiceImpl.getInstance();
	
	@Before
	public void before() {
		response = null;
		service = ParkingServiceImpl.getInstance();
		service.deleteParkingManager();
	}
	
	@After
	public void after() {
		service.deleteParkingManager();
		service = null;
	}
	
	@Test
	public void createParkingLotTest() {
		
		response = service.createParkingLot(5);
		assertEquals(response, "Created a parking lot with 5 slots");

		service.deleteParkingManager();
		response = service.createParkingLot(10);
		assertEquals(response, "Created a parking lot with 10 slots");

	}
	
	
	@Test
	public void reserveParkingSlotTest() {
		
		service.createParkingLot(2);
		
		response = service.reserveParkingSlot("ABAB", "Blue");
		assertEquals(response, "Allocated slot number: 1.");

		response = service.reserveParkingSlot("BCBC", "Blue");
		assertEquals(response, "Allocated slot number: 2.");

		response = service.reserveParkingSlot("BCBC", "Red");
		assertEquals(response, "Sorry, parking lot is full.");

	}
	
	@Test
	public void leaveParkingSlotTest() {
		
		service.createParkingLot(5);
		service.reserveParkingSlot("ABAB", "Blue");
		service.reserveParkingSlot("BCBC", "Red");
		
		response = service.leaveParkingSlot(1);
		assertEquals(response, "Slot number 1 is free.");

		response = service.leaveParkingSlot(2);
		assertEquals(response, "Slot number 2 is free.");

		response = service.leaveParkingSlot(3);
		assertEquals(response, "Parking spot:3 is already vacant!!!.");

		response = service.leaveParkingSlot(22);
		assertEquals(response, "Invalid parking spot index entered.");

	}
	
	@Test
	public void getParkingSlotStatusTest(){
		
		service.createParkingLot(5);
		service.reserveParkingSlot("ABAB", "Blue");
		service.reserveParkingSlot("BCBC", "Red");
		
		response = service.getParkingSlotStatus();
		assertTrue(response.contains("ABAB"));
		assertTrue(response.contains("BCBC"));
		assertTrue(response.contains("Blue"));
		assertTrue(response.contains("Red"));
		assertFalse(response.contains("CDCD"));
		
	}
	
	@Test
	public void deleteParkingManagerTest(){
		
		assertFalse(service.isParkingLotInitialised());
		service.createParkingLot(5);
		assertTrue(service.isParkingLotInitialised());
		
		service.deleteParkingManager();
		assertFalse(service.isParkingLotInitialised());
		
	}
	
	@Test
	public void isParkingLotInitialisedTest(){
		
		assertFalse(service.isParkingLotInitialised());
		service.createParkingLot(5);
		assertTrue(service.isParkingLotInitialised());
		
	}

	
	@Test
	public void getSlotNumbersForCarsWithColorTest(){
		
		service.createParkingLot(5);
		service.reserveParkingSlot("AA", "Blue");
		service.reserveParkingSlot("BB", "Red");
		service.reserveParkingSlot("CC", "Blue");
		service.reserveParkingSlot("DD", "White");
		
		response = service.getSlotNumbersForCarsWithColor("Blue");
		assertEquals(response, "[1, 3]");
		
		response = service.getSlotNumbersForCarsWithColor("Red");
		assertEquals(response, "[2]");
		
		response = service.getSlotNumbersForCarsWithColor("White");
		assertEquals(response, "[4]");

		response = service.getSlotNumbersForCarsWithColor("Orange");
		assertEquals(response, ParkingConstants.NOT_FOUND);

	}
	
	@Test
	public void getRegistrationNumberForCarsWithColorTest(){
		
		service.createParkingLot(5);
		service.reserveParkingSlot("AA", "Blue");
		service.reserveParkingSlot("BB", "Red");
		service.reserveParkingSlot("CC", "Blue");
		service.reserveParkingSlot("DD", "White");
		
		response = service.getRegistrationNumberForCarsWithColor("Blue");
		assertEquals(response, "[AA, CC]");
		
		response = service.getRegistrationNumberForCarsWithColor("Red");
		assertEquals(response, "[BB]");
		
		response = service.getRegistrationNumberForCarsWithColor("White");
		assertEquals(response, "[DD]");

		response = service.getRegistrationNumberForCarsWithColor("Orange");
		assertEquals(response, ParkingConstants.NOT_FOUND);

	}
	
	@Test
	public void getSlotNumbersForRegistrationNumberTest(){
		
		service.createParkingLot(5);
		service.reserveParkingSlot("AA", "Blue");
		service.reserveParkingSlot("BB", "Red");
		service.reserveParkingSlot("CC", "Blue");
		service.reserveParkingSlot("DD", "White");
		
		response = service.getSlotNumbersForRegistrationNumber("AA");
		assertEquals(response, "[1]");
		
		response = service.getSlotNumbersForRegistrationNumber("BB");
		assertEquals(response, "[2]");
		
		response = service.getSlotNumbersForRegistrationNumber("DD");
		assertEquals(response, "[4]");

		response = service.getSlotNumbersForRegistrationNumber("EE");
		assertEquals(response, ParkingConstants.NOT_FOUND);

	}

}