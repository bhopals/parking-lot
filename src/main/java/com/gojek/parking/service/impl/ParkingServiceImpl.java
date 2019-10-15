package com.gojek.parking.service.impl;

import com.gojek.parking.constant.ParkingConstants;
import com.gojek.parking.dao.ParkingDao;
import com.gojek.parking.dao.impl.ParkingDaoImpl;
import com.gojek.parking.exception.ParkingException;
import com.gojek.parking.model.Car;
import com.gojek.parking.service.ParkingService;

/**
 * @author Bhopal Singh
 * 
 *  Parking Service Class
 *   
 *    - A layer Between DAO and the Command Manager.
 *    - Also handles transformation or Printing of the data result.
 *
 */
public class ParkingServiceImpl implements ParkingService {

	ParkingDao parkingDao = ParkingDaoImpl.getInstance();
	
	private static ParkingService instance = null;
	
	public static ParkingService getInstance() {	
		if(null == instance) {
			synchronized(ParkingService.class) {				
				if(null == instance) {
					instance = new ParkingServiceImpl();
				}
			}
		}
		return instance;
	}
	
	@Override
	public void createParkingLot(int numberOfSpotsForParking) throws ParkingException {
		if(parkingDao.initParkingManager(numberOfSpotsForParking)) {
			System.out.println(ParkingConstants.CREATE_SUCCESS.replaceAll(ParkingConstants.REPLACER, String.valueOf(numberOfSpotsForParking)));
		} else {
			System.out.println("Parking Manager Already Exists. Kindly run 'RESET' to delete existing and then try creating again");
		}
		
	}

	@Override
	public void reserveParkingSlot(String registrationNumber, String color) throws ParkingException {
		Integer slot = parkingDao.reserveParkingSpot(new Car(registrationNumber, color));
		if(null != parkingDao.reserveParkingSpot(new Car(registrationNumber, color))) {
			System.out.println("Allocated slot number: "+slot);
		} else {
			System.out.println("Sorry, parking lot is full");
		}
	}

	@Override
	public void leaveParkingSlot(int spot) throws ParkingException {
		if(parkingDao.unReserveParkingSpot(spot)){
			System.out.println("Slot number "+spot+" is free");
		} else {
			System.out.println("Parking spot:"+spot+" is already vacant!!!");
		}
	}

	@Override
	public void getParkingSlotStatus() {
		System.out.println("Slot No. Reg.No.  	 Color ");
		System.out.println("------------------------------------------------------------");		
		System.out.println(parkingDao.getParkingSlotStatus());		
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

	@Override
	public boolean isParkingLotInitialised() {
		return parkingDao.isParkingLotInitialised();
	}

}
