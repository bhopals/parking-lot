package com.gojek.parking.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gojek.parking.constant.ParkingConstants;
import com.gojek.parking.dao.ParkingDao;
import com.gojek.parking.model.Car;

/**
 * @author Bhopal Singh
 *
 * ParkingDaoImpl 
 * 
 * 	- Handles all the operation on the MAP data which stores Parking Details 
 * 	
 *
 */
public class ParkingDaoImpl implements ParkingDao {

	private Map<Integer, Car> parkingDataMap = null;
	private Integer parkingSpotSize = null;
	private static ParkingDao instance = null;
	
	public static ParkingDao getInstance() {	
		if(null == instance) {
			synchronized(ParkingDao.class) {				
				if(null == instance) {
					instance = new ParkingDaoImpl();
				}
			}
		}
		return instance;
	}
	
	@Override
	public boolean initParkingManager(int numberOfParkingSpots) {
		boolean isParkingManagerInitialized = false;
		if(this.parkingDataMap == null) {	
			this.parkingSpotSize = numberOfParkingSpots;
			this.parkingDataMap = Collections.synchronizedMap(new HashMap<Integer, Car>());
			
			for(int i=1;i<=numberOfParkingSpots;i++){
				this.parkingDataMap.put(i, null);
			}
			isParkingManagerInitialized = true;
		} 
		
		return isParkingManagerInitialized;
	}

	@Override
	public boolean deleteParkingManager() {
		boolean isParkingManagerDeleted = false;
		if(null != parkingDataMap) {
			this.parkingDataMap = null;
			this.parkingSpotSize = null;
			isParkingManagerDeleted = true;
		} 
		return isParkingManagerDeleted;

	}

	@Override
	public Integer reserveParkingSpot(Car car) {
		Integer emptySpot = null;
		for (Map.Entry<Integer, Car> entry : this.parkingDataMap.entrySet()) {
		    if(entry.getValue() == null) {
		    	emptySpot = entry.getKey();
		    	break;
		    }
		}
		
		if(null != emptySpot) {
			this.parkingDataMap.put(emptySpot, car);
		}
		return emptySpot;
		
	}

	@Override
	public Integer unReserveParkingSpot(int spot) {
		Integer unReservedSpot = 0;
		if(spot > this.parkingSpotSize) {
			unReservedSpot = -1;
		} else {
			Car car = this.parkingDataMap.get(spot);
			if(null != car){
				unReservedSpot = 1;
				this.parkingDataMap.put(spot, null);
			} 
		}
		return unReservedSpot;
	}

	@Override
	public String getSlotNumbersForCarsWithColor(String color) {
		List<String> list = new ArrayList<String>(parkingSpotSize);
		for (Map.Entry<Integer, Car> entry : this.parkingDataMap.entrySet()) {
		    Car car = entry.getValue();	
		    if(null != car && color.equalsIgnoreCase(car.getColor())) {
		    	list.add(entry.getKey().toString());
		    }
		}
		return returnParkingDataMapResult(list);		
	}

	@Override
	public String getRegistrationNumberForCarsWithColor(String color) {
		List<String> list = new ArrayList<String>(parkingSpotSize);
		for (Map.Entry<Integer, Car> entry : this.parkingDataMap.entrySet()) {
		    Car car = entry.getValue();
		    if(null != car && color.equalsIgnoreCase(car.getColor())) {
		    	list.add(car.getRegistrationNumber());
		    } 			
		}
		return returnParkingDataMapResult(list);		
	}

	@Override
	public String getSlotNumbersForRegistrationNumber(String registrationNumber) {
		List<String> list = new ArrayList<String>(parkingSpotSize);
		for (Map.Entry<Integer, Car> entry : this.parkingDataMap.entrySet()) {
		    Car car = entry.getValue();
		    if(null != car && registrationNumber.equalsIgnoreCase(car.getRegistrationNumber())) {
		    	list.add(entry.getKey().toString());
		    } 			
		}
		return returnParkingDataMapResult(list);		
	}
	
	@Override
	public String getParkingSlotStatus() {
		boolean isReservedSlot = false;
		StringBuilder message = new StringBuilder();
		if(null != this.parkingDataMap) {
			for (Map.Entry<Integer, Car> entry : this.parkingDataMap.entrySet()) {
				Car car = entry.getValue();
				if(null != car) {
					isReservedSlot = true;
					message.append(entry.getKey()).append(ParkingConstants.DOUBLE_SPACER)
							.append(car.getRegistrationNumber()).append(ParkingConstants.DOUBLE_SPACER)
							.append(car.getColor()).append(ParkingConstants.NEW_LINE);
				}
			}
		}
		
		if(isReservedSlot) {
			return message.toString();
		} else {
			return ParkingConstants.NO_SLOT_FOUND;
		}
		
	}

	@Override
	public boolean isParkingLotInitialised() {
		return this.parkingDataMap == null ? false : true;
	}
	
	private String returnParkingDataMapResult(List<String> list) {
		if(!list.isEmpty()) {
			return list.toString();
		} else {
			return ParkingConstants.NOT_FOUND;
		}
	}

}
