package com.gojek.parking.dao;

import java.util.HashMap;
import java.util.Map;

public class ParkingDaoTest {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		System.out.println("map:"+map);
		map = new HashMap<Integer, String>(6);
		System.out.println("map:"+map);
		map = new HashMap<Integer, String>(2);
		System.out.println("map:"+map);
		
	}
}
