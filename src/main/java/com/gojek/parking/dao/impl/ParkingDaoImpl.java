package com.gojek.parking.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gojek.parking.constant.ParkingConstants;
import com.gojek.parking.dao.ParkingDao;
import com.gojek.parking.exception.ParkingException;
import com.gojek.parking.model.Car;

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
	public void initParkingManager(int numberOfParkingSpots) throws ParkingException {
		if(this.parkingDataMap == null) {	
			this.parkingSpotSize = numberOfParkingSpots;
			this.parkingDataMap = new HashMap<Integer, Car>(numberOfParkingSpots);
			for(int i=0;i<numberOfParkingSpots;i++){
				this.parkingDataMap.put(i, null);
			}
		} else {
			throw new ParkingException("Parking Manager Already Exists. Kindly run 'RESET' to delete existing and then try creating again");
		}
	}

	@Override
	public void deleteParkingManager() throws ParkingException {
		this.parkingDataMap = null;
		this.parkingSpotSize = null;

	}

	@Override
	public Integer reserveParkingSpot(Car car) throws ParkingException {
		Integer emptySpot = null;
		for (Map.Entry<Integer, Car> entry : this.parkingDataMap.entrySet()) {
		    if(entry.getValue() == null) {
		    	emptySpot = entry.getKey();
		    	break;
		    }
		}
		
		if(null != emptySpot) {
			this.parkingDataMap.put(emptySpot, car);
		} else {
			throw new ParkingException("Sorry, parking lot is full");
		}
		return emptySpot;
		
	}

	@Override
	public void unReserveParkingSpot(int spot) throws ParkingException {
		Car car = this.parkingDataMap.get(spot);
		if(null != car){
			this.parkingDataMap.put(spot, null);
		} else {
			throw new ParkingException("Parking spot is already vacant!!!");
		}
		
	}

	@Override
	public String getSlotNumbersForCarsWithColor(String color) {
		List<String> list = new ArrayList<String>(parkingSpotSize);
		for (Map.Entry<Integer, Car> entry : this.parkingDataMap.entrySet()) {
		    Car car = entry.getValue();		    
		    if(color.equalsIgnoreCase(car.getColor())) {
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
		    if(color.equalsIgnoreCase(car.getColor())) {
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
		    if(registrationNumber.equalsIgnoreCase(car.getRegistrationNumber())) {
		    	list.add(entry.getKey().toString());
		    } 			
		}
		return returnParkingDataMapResult(list);		
	}
	
	private String returnParkingDataMapResult(List<String> list) {
		if(list.isEmpty()) {
			return list.toString();
		} else {
			return ParkingConstants.NOT_FOUND;
		}
	}

	@Override
	public Map<Integer, Car> getParkingSlotStatus() {
		return this.parkingDataMap;
	}

}
