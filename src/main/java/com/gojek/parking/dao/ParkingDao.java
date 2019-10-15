package com.gojek.parking.dao;

import com.gojek.parking.exception.ParkingException;

public interface ParkingDao {
	
	String initParkingManager(int numberOfParkingSpots) throws ParkingException;
	
	String deleteParkingManager() throws ParkingException;
	
	String reserveParkingSpot(int spot) throws ParkingException; 

}
