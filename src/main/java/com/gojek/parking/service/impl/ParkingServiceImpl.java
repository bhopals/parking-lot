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
 *         Parking Service Class
 * 
 *         - A layer Between DAO and the Command Manager. - Also handles
 *         transformation or Printing of the data result.
 *
 */
public class ParkingServiceImpl implements ParkingService {

	ParkingDao parkingDao = ParkingDaoImpl.getInstance();

	private static ParkingService instance = null;

	public static ParkingService getInstance() {
		if (null == instance) {
			synchronized (ParkingService.class) {
				if (null == instance) {
					instance = new ParkingServiceImpl();
				}
			}
		}
		return instance;
	}

	@Override
	public void createParkingLot(int numberOfSpotsForParking) throws ParkingException {
		if (parkingDao.initParkingManager(numberOfSpotsForParking)) {
			System.out.println(ParkingConstants.CREATE_SUCCESS.replaceAll(ParkingConstants.REPLACER,
					String.valueOf(numberOfSpotsForParking)));
		} else {
			System.out.println(ParkingConstants.CREATE_ERROR);
		}
	}

	@Override
	public void reserveParkingSlot(String registrationNumber, String color) throws ParkingException {
		Integer slot = parkingDao.reserveParkingSpot(new Car(registrationNumber, color));
		if (null != slot) {
			System.out.println(
					ParkingConstants.RESERVE_SLOT_SUCCESS.replaceAll(ParkingConstants.REPLACER, String.valueOf(slot)));
		} else {
			System.out.println(ParkingConstants.RESERVE_SLOT_ERROR);
		}
	}

	@Override
	public void leaveParkingSlot(int spot) throws ParkingException {
		int value = parkingDao.unReserveParkingSpot(spot);
		if (value == 1) {
			System.out.println(ParkingConstants.UNRESERVE_SLOT_SUCCESS.replaceAll(ParkingConstants.REPLACER,
					String.valueOf(spot)));
		} else if(value == 0){
			System.out.println(
					ParkingConstants.UNRESERVE_SLOT_ERROR.replaceAll(ParkingConstants.REPLACER, String.valueOf(spot)));
		} else {
			System.out.println(ParkingConstants.UNRESERVE_SLOT_INVALID_INDEX);
		}
	}

	@Override
	public void getParkingSlotStatus() {
		System.out.println(ParkingConstants.SLOT_STATUS_HEADER);
		System.out.println(ParkingConstants.SLOT_HEADER_SEP);
		System.out.println(parkingDao.getParkingSlotStatus());
		System.out.println(ParkingConstants.SLOT_HEADER_SEP);
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
		if(parkingDao.deleteParkingManager())
			System.out.println(ParkingConstants.DELETE_SUCCESS);
	}

	@Override
	public boolean isParkingLotInitialised() {
		return parkingDao.isParkingLotInitialised();
	}

}
