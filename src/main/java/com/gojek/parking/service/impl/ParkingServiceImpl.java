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
	public String createParkingLot(int numberOfSpotsForParking) {
		if (parkingDao.initParkingManager(numberOfSpotsForParking)) {
			return ParkingConstants.CREATE_SUCCESS.replaceAll(ParkingConstants.REPLACER,
					String.valueOf(numberOfSpotsForParking));
		} else {
			return ParkingConstants.CREATE_ERROR;
		}
	}

	@Override
	public String reserveParkingSlot(String registrationNumber, String color) {
		Integer slot = parkingDao.reserveParkingSpot(new Car(registrationNumber, color));
		if (null != slot) {
			return ParkingConstants.RESERVE_SLOT_SUCCESS.replaceAll(ParkingConstants.REPLACER, String.valueOf(slot));
		} else {
			return ParkingConstants.RESERVE_SLOT_ERROR;
		}
	}

	@Override
	public String leaveParkingSlot(int spot) {
		int value = parkingDao.unReserveParkingSpot(spot);
		if (value == 1) {
			return ParkingConstants.UNRESERVE_SLOT_SUCCESS.replaceAll(ParkingConstants.REPLACER,
					String.valueOf(spot));
		} else if(value == 0){
			return ParkingConstants.UNRESERVE_SLOT_ERROR.replaceAll(ParkingConstants.REPLACER, String.valueOf(spot));
		} else {
			return ParkingConstants.UNRESERVE_SLOT_INVALID_INDEX;
		}
	}

	@Override
	public String getParkingSlotStatus() {
		StringBuilder msg = new StringBuilder();
		msg.append(ParkingConstants.SLOT_STATUS_HEADER)
		.append(ParkingConstants.NEW_LINE)
		.append(ParkingConstants.SLOT_HEADER_SEP)
		.append(ParkingConstants.NEW_LINE)
		.append(parkingDao.getParkingSlotStatus())
		.append(ParkingConstants.SLOT_HEADER_SEP);
		
		return msg.toString();
	}

	@Override
	public String getSlotNumbersForCarsWithColor(String color) {
		return parkingDao.getSlotNumbersForCarsWithColor(color);
	}

	@Override
	public String getRegistrationNumberForCarsWithColor(String color) {
		return parkingDao.getRegistrationNumberForCarsWithColor(color);
	}

	@Override
	public String getSlotNumbersForRegistrationNumber(String registrationNumber) {
		return parkingDao.getSlotNumbersForRegistrationNumber(registrationNumber);
	}

	@Override
	public String deleteParkingManager() {
		if(parkingDao.deleteParkingManager())
			return ParkingConstants.DELETE_SUCCESS;
		 else 
		 	return ParkingConstants.DELETE_ERROR;
	}

	@Override
	public boolean isParkingLotInitialised() {
		return parkingDao.isParkingLotInitialised();
	}

}
