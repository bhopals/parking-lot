package com.gojek.parking.dao;

import com.gojek.parking.exception.ParkingException;
import com.gojek.parking.model.Car;

public interface ParkingDao {
		
	boolean initParkingManager(int numberOfParkingSpots) throws ParkingException;
	
	boolean deleteParkingManager() throws ParkingException;
	
	String getParkingSlotStatus(); 
	
	Integer reserveParkingSpot(Car car) throws ParkingException; 
	
	boolean unReserveParkingSpot(int spot) throws ParkingException; 
	
	String getSlotNumbersForCarsWithColor(String color);
	
	String getRegistrationNumberForCarsWithColor(String color);
	
	String getSlotNumbersForRegistrationNumber(String registrationNumber);
	
	boolean isParkingLotInitialised();
	
}
