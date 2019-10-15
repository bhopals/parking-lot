package com.gojek.parking.dao;

import com.gojek.parking.model.Car;

public interface ParkingDao {
		
	boolean initParkingManager(int numberOfParkingSpots) ;
	
	boolean deleteParkingManager() ;
	
	String getParkingSlotStatus(); 
	
	Integer reserveParkingSpot(Car car) ; 
	
	Integer unReserveParkingSpot(int spot) ; 
	
	String getSlotNumbersForCarsWithColor(String color);
	
	String getRegistrationNumberForCarsWithColor(String color);
	
	String getSlotNumbersForRegistrationNumber(String registrationNumber);
	
	boolean isParkingLotInitialised();
	
}
