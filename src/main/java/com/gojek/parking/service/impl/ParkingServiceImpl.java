package com.gojek.parking.service.impl;

import java.util.Map;

import com.gojek.parking.dao.ParkingDao;
import com.gojek.parking.dao.impl.ParkingDaoImpl;
import com.gojek.parking.exception.ParkingException;
import com.gojek.parking.model.Car;
import com.gojek.parking.service.ParkingService;

public class ParkingServiceImpl implements ParkingService {

	ParkingDao parkingDao = new ParkingDaoImpl().getInstance();
	
	@Override
	public String createParkingLot(int numberOfSpotsForParking) throws ParkingException {
		parkingDao.initParkingManager(numberOfSpotsForParking);
		return "Created a parking lot with "+numberOfSpotsForParking+" slots";
	}

	@Override
	public String reserveParkingSlot(String registrationNumber, String color) throws ParkingException {
		int slot = parkingDao.reserveParkingSpot(new Car(registrationNumber, color));
		return "Allocated slot number: "+slot;
	}

	@Override
	public String leaveParkingSlot(int spot) throws ParkingException {
		parkingDao.unReserveParkingSpot(spot);
		return "Slot number "+spot+" is free";
	}

	@Override
	public void getParkingSlotStatus() {
		System.out.println("Slot No. Registration No.              Color ");
		System.out.println("------------------------------------------------------------");		
		for (Map.Entry<Integer, Car> entry : parkingDao.getParkingSlotStatus().entrySet()) {
		    Car car = entry.getValue();
		    System.out.println(entry.getKey()+" "+car.getRegistrationNumber()+"              "+car.getColor());			
		}		
		System.out.println("------------------------------------------------------------");
		
	}

	@Override
	public void getSlotNumbersForCarsWithColor(String color) {
		System.out.println(parkingDao.getSlotNumbersForCarsWithColor(color));		
	}

	@Override
	public void getRegistrationNumberForCarsWithColor(String color) {
		System.out.println(parkingDao.getRegistrationNumberForCarsWithColor(color));		
	}

	@Override
	public void getSlotNumbersForRegistrationNumber(String registrationNumber) {
		System.out.println(parkingDao.getSlotNumbersForRegistrationNumber(registrationNumber));		
	}

	@Override
	public void deleteParkingManager() throws ParkingException {
		parkingDao.deleteParkingManager();
	}

}
