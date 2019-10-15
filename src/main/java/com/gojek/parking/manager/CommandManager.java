package com.gojek.parking.manager;

import java.util.HashMap;
import java.util.Map;

import com.gojek.parking.constant.ParkingCommands;

public class CommandManager {
	
	private static Map<String, Integer> commandMap = new HashMap<String, Integer>(){{
        put(ParkingCommands.LEAVE.getValue(), 0);
        put(ParkingCommands.RESET.getValue(), 0);
        put(ParkingCommands.STATUS.getValue(), 0);
        put(ParkingCommands.SLOTS_NUMBER_FOR_CARS_WITH_COLOR.getValue(), 1);
        put(ParkingCommands.SLOTS_NUMBER_FOR_REGISTRATION_NUMBER.getValue(), 1);
        put(ParkingCommands.REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR.getValue(), 1);
    }};
	
	
	/**
	 * @return the commandMap
	 */
	public Map<String, Integer> getCommandMap() {
		return commandMap;
	}

	
}
