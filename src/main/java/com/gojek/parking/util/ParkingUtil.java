package com.gojek.parking.util;

import com.gojek.parking.constant.ParkingConstants;

public class ParkingUtil {
	
	public static boolean isNotNullOrNonEmptyString(String string){
		return null == string || ParkingConstants.EMPTY.equals(string) ? false : true; 
	}

}
