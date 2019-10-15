package com.gojek.parking.dao;

import com.gojek.parking.exception.ParkingException;
import com.gojek.parking.model.Car;

public interface ParkingDao {
	
	
	void initParkingManager(int numberOfParkingSpots) throws ParkingException;
	
	void deleteParkingManager() throws ParkingException;
	
	Integer reserveParkingSpot(Car car) throws ParkingException; 
	
	void unReserveParkingSpot(int spot) throws ParkingException; 
	
}
