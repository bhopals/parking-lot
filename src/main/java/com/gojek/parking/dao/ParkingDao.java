package com.gojek.parking.dao;

import java.util.Map;

import com.gojek.parking.exception.ParkingException;
import com.gojek.parking.model.Car;

public interface ParkingDao {
		
	void initParkingManager(int numberOfParkingSpots) throws ParkingException;
	
	void deleteParkingManager() throws ParkingException;
	
	Map<Integer, Car> getParkingSlotStatus(); 
	
	Integer reserveParkingSpot(Car car) throws ParkingException; 
	
	void unReserveParkingSpot(int spot) throws ParkingException; 
	
	String getSlotNumbersForCarsWithColor(String color);
	
	String getRegistrationNumberForCarsWithColor(String color);
	
	String getSlotNumbersForRegistrationNumber(String registrationNumber);
	
	
}
