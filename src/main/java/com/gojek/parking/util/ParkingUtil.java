package com.gojek.parking.util;

import com.gojek.parking.constant.ParkingConstants;

/**
 * @author Bhopal Singh
 * 
 *  UTILITLY Methods
 *
 */
public class ParkingUtil {
	
	public static boolean isNotNullOrNonEmptyString(String string){
		return null == string || ParkingConstants.EMPTY.equals(string) ? false : true; 
	}

}
