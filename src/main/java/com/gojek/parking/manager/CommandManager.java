package com.gojek.parking.manager;

import java.util.HashMap;
import java.util.Map;

import com.gojek.parking.constant.ParkingCommands;
import com.gojek.parking.exception.ParkingException;
import com.gojek.parking.service.ParkingService;
import com.gojek.parking.service.impl.ParkingServiceImpl;

public class CommandManager {
	
	private static CommandManager commandManager;
	
	private ParkingService parkingService = ParkingServiceImpl.getInstance();
	
	private static Map<String, Integer> commandMap = new HashMap<String, Integer>(){{
        put(ParkingCommands.LEAVE.getValue(), 0);
        put(ParkingCommands.RESET.getValue(), 0);
        put(ParkingCommands.STATUS.getValue(), 0);
        put(ParkingCommands.PARK.getValue(), 2);
        put(ParkingCommands.CREATE_PARKING_LOT.getValue(), 1);
        put(ParkingCommands.SLOTS_NUMBER_FOR_CARS_WITH_COLOR.getValue(), 1);
        put(ParkingCommands.SLOTS_NUMBER_FOR_REGISTRATION_NUMBER.getValue(), 1);
        put(ParkingCommands.REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR.getValue(), 1);
    }};
	
    
	private CommandManager() {
		super();
	}
	
	public static CommandManager getInstance() {		
		synchronized (commandMap) {
			if(null == commandManager) {
				commandManager = new CommandManager();
			}		
		}		
		return commandManager;
	}

	/**
	 * @return the commandMap
	 */
	public Map<String, Integer> getCommandMap() {
		return commandMap;
	}

	public boolean isValidCommandEntered(String array[]) throws ParkingException {
		
		Integer paramValue;
		boolean isValidCommand = false;
		
		/*** FETCH Parameters from INPUT Variable
		 * 
		 *  	- COMMAND
		 *      - PARAM VALUE
		 *      
		 ***/
		paramValue = commandMap.get(array[0].toLowerCase());
		
		/*** COMMAND FOUND ***/
		if(null != paramValue) {
			
			/***  PARAMETER EXPECTED - INVALID****/
			if(paramValue.intValue() > 0 && paramValue.intValue()+1 != array.length) {
				throw new ParkingException("MISSING PARAMETER in COMMAND:"+ array[0]);
				
			} else {				
				/**** VALID ***/
				isValidCommand = true;
			}
			
		} else {/*** COMMAND NOT FOUND ***/			
			throw new ParkingException("NO COMMAND FOUND:"+ array[0]);
		}		
		
		return isValidCommand;
	}
	
	
	/*****
	 *  Command execution Block
	 *  
	 * @param array
	 * @throws ParkingException 
	 */
	public void executeCommand(String array[]) throws ParkingException {
		
		String commandValue = array[0];
		
		/**** STEP1. Check if PARKING data is INITIALIZED. If not then Throw EXCEPTION ***/
		if(!ParkingCommands.CREATE_PARKING_LOT.getValue().equalsIgnoreCase(commandValue)
				&& !parkingService.isParkingLotInitialised()) {
			throw new ParkingException("Parking Lot in not initilized. Kindly run 'create_parking_log' <number> command");
		}
		
		System.out.println("commandValue: "+commandValue);
		/**** STEP2. Parking Lot Command Operations ***/
		if(ParkingCommands.CREATE_PARKING_LOT.getValue().equalsIgnoreCase(commandValue)) {
			
			Integer val = Integer.parseInt(array[1]);				
			parkingService.createParkingLot(val);
			
		} else if(ParkingCommands.PARK.getValue().equalsIgnoreCase(commandValue)) {
			parkingService.reserveParkingSlot(array[1], array[2]);
		} else if(ParkingCommands.LEAVE.getValue().equalsIgnoreCase(commandValue)) {
			parkingService.leaveParkingSlot(Integer.parseInt(array[1]));
		} else if(ParkingCommands.RESET.getValue().equalsIgnoreCase(commandValue)) {
			parkingService.deleteParkingManager();			
		} else if(ParkingCommands.STATUS.getValue().equalsIgnoreCase(commandValue)) {
			parkingService.getParkingSlotStatus();
			
		} else if(ParkingCommands.REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR.getValue().equalsIgnoreCase(commandValue)) {
			parkingService.getRegistrationNumberForCarsWithColor(array[1]);
			
		} else if(ParkingCommands.SLOTS_NUMBER_FOR_REGISTRATION_NUMBER.getValue().equalsIgnoreCase(commandValue)) {
			parkingService.getSlotNumbersForRegistrationNumber(array[1]);
			
		} else if(ParkingCommands.SLOTS_NUMBER_FOR_CARS_WITH_COLOR.getValue().equalsIgnoreCase(commandValue)) {
			parkingService.getSlotNumbersForCarsWithColor(array[1]);
			
		} else {
			System.out.println("You should not be here!!!");
		}

		System.out.println("----current status start -----");
		parkingService.getParkingSlotStatus();
		System.out.println("----current status ends -----");
		
	}
}
