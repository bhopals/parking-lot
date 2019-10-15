package com.gojek.parking.service;

import com.gojek.parking.exception.ParkingException;

public interface ParkingService {

	String createParkingLot(int numberOfSpotsForParking) throws ParkingException;
	
	String reserveParkingSlot(String registrationNumber, String color) throws ParkingException;
	
	String leaveParkingSlot(int spot) throws ParkingException;
	
	void getParkingSlotStatus();
	
	void getSlotNumbersForCarsWithColor(String color);
	
	void getRegistrationNumberForCarsWithColor(String color);
	
	void getSlotNumbersForRegistrationNumber(String registrationNumber);
	
	void deleteParkingManager() throws ParkingException;
	
	boolean isParkingLotInitialised();

}
