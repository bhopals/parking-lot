package com.gojek.parking.service;

public interface ParkingService {

	String createParkingLot(int numberOfSpotsForParking);
	
	String reserveParkingSlot(String registrationNumber, String color);
	
	String leaveParkingSlot(int spot);
	
	String getParkingSlotStatus();
	
	String getSlotNumbersForCarsWithColor(String color);
	
	String getRegistrationNumberForCarsWithColor(String color);
	
	String getSlotNumbersForRegistrationNumber(String registrationNumber);
	
	String deleteParkingManager();
	
	boolean isParkingLotInitialised();

}
