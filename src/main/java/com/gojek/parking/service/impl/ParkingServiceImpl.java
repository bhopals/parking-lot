package com.gojek.parking.service.impl;

import com.gojek.parking.exception.ParkingException;
import com.gojek.parking.service.ParkingService;

public class ParkingServiceImpl implements ParkingService {

	@Override
	public String createParkingLot(int numberOfSpotsForParking) throws ParkingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String reserveParkingSlot(String registrationNumber, String color) throws ParkingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String leaveParkingSlot(int spot) throws ParkingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void getParkingSlotStatus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSlotNumbersForCarsWithColor(String color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getRegistrationNumberForCarsWithColor(String color) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getSlotNumbersForRegistrationNumber(String registrationNumber) {
		// TODO Auto-generated method stub
		
	}

}
