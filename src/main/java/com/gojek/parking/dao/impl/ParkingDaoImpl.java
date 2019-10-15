package com.gojek.parking.dao.impl;

import java.util.HashMap;
import java.util.Map;

import com.gojek.parking.dao.ParkingDao;
import com.gojek.parking.exception.ParkingException;
import com.gojek.parking.model.Car;

public class ParkingDaoImpl implements ParkingDao {

	private Map<Integer, Car> parkingDataMap = null;
	private Integer parkingSpotSize = null;
	private ParkingDao instance = null;
	
	public ParkingDao getInstance() {	
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
		if(this.parkingDataMap.size() == this.parkingSpotSize) {
			throw new ParkingException("Parking SPOT is full!!");
		} else {
			//TODO - Allocate Parking Space
		}
		return null;
		
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

}
