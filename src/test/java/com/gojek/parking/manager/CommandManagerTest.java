package com.gojek.parking.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.parking.constant.ParkingCommands;
import com.gojek.parking.constant.ParkingConstants;
import com.gojek.parking.exception.ParkingException;

public class CommandManagerTest {

	CommandManager manager = CommandManager.getInstance();
	
	@Before
	public void before() throws ParkingException {
		manager.isValidCommandEntered(new String[]{ParkingCommands.RESET.getValue()});
	}
	
	@After
	public void after() {
		//TODO
	}
	
	@Test
	public void isValidCommandEnteredTest() throws ParkingException {
	
		boolean result;
		
		/**** CREATE ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.CREATE_PARKING_LOT.getValue(),"5"});
		assertEquals(true, result);
		
		/**** PARK ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.PARK.getValue(),"TATA","White"});
		assertEquals(true, result);

		/**** LEAVE ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.LEAVE.getValue(),"5"});
		assertEquals(true, result);
		
		/**** STATUS ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.STATUS.getValue()});
		assertEquals(true, result);

		/**** HELP ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.HELP.getValue()});
		assertEquals(true, result);

		/**** RESET ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.RESET.getValue()});
		assertEquals(true, result);
		
		/**** FETCH  - REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR.getValue(), "White"});
		assertEquals(true, result);

		/**** FETCH  - SLOTS_NUMBER_FOR_REGISTRATION_NUMBER ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.SLOTS_NUMBER_FOR_REGISTRATION_NUMBER.getValue(), "ABABA"});
		assertEquals(true, result);
		
		/**** FETCH  - SLOTS_NUMBER_FOR_CARS_WITH_COLOR ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.SLOTS_NUMBER_FOR_CARS_WITH_COLOR.getValue(), "Blue"});
		assertEquals(true, result);

	}
	

	@Test(expected = ParkingException.class)
	public void isValidCommandEnteredExceptionTest() throws ParkingException{
	
		boolean result;
		
		/**** CREATE ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.CREATE_PARKING_LOT.getValue(), "55", "TEST"});
		
		/**** PARK ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.PARK.getValue(),"TATA"});

		/**** LEAVE ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.LEAVE.getValue()});
		
		/**** STATUS ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.STATUS.getValue(), "Test"});

		/**** HELP ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.HELP.getValue(), "ADA"});

		/**** RESET ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.RESET.getValue(),"AAA"});
		
		/**** FETCH  - REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR.getValue()});

		/**** FETCH  - SLOTS_NUMBER_FOR_REGISTRATION_NUMBER ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.SLOTS_NUMBER_FOR_REGISTRATION_NUMBER.getValue()});
		
		/**** FETCH  - SLOTS_NUMBER_FOR_CARS_WITH_COLOR ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.SLOTS_NUMBER_FOR_CARS_WITH_COLOR.getValue()});

		/*** INVALID WITH DUMMY **/
		result = manager.isValidCommandEntered(new String[]{"",""});
		assertEquals(true, result);
	}

	@Test
	public void executeCommandTest() throws ParkingException {
	
		String response;
		
		/**** CREATE ***/
		response = manager.executeCommand(new String[]{ParkingCommands.CREATE_PARKING_LOT.getValue(),"10"});
		assertEquals(response, "Created a parking lot with 10 slots");
		
		/**** PARK ***/
		response = manager.executeCommand(new String[]{ParkingCommands.PARK.getValue(),"TATA","White"});
		assertEquals(response, "Allocated slot number: 1.");

		/**** LEAVE ***/
		response = manager.executeCommand(new String[]{ParkingCommands.LEAVE.getValue(),"1"});
		assertEquals(response, "Slot number 1 is free.");
		
		/**** STATUS ***/
		manager.executeCommand(new String[]{ParkingCommands.PARK.getValue(),"TATA","White"});
		manager.executeCommand(new String[]{ParkingCommands.PARK.getValue(),"ABAC","White"});

		response = manager.executeCommand(new String[]{ParkingCommands.STATUS.getValue()});
		assertTrue(response.contains("TATA"));
		assertTrue(response.contains("ABAC"));
		
		/**** FETCH  - REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR ***/
		response = manager.executeCommand(new String[]{ParkingCommands.REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR.getValue(), "White"});
		assertEquals(response, "[TATA, ABAC]");
		
		response = manager.executeCommand(new String[]{ParkingCommands.REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR.getValue(), "Orange"});
		assertEquals(response, ParkingConstants.NOT_FOUND);
		
		/**** FETCH  - SLOTS_NUMBER_FOR_REGISTRATION_NUMBER ***/
		response = manager.executeCommand(new String[]{ParkingCommands.SLOTS_NUMBER_FOR_REGISTRATION_NUMBER.getValue(), "TATA"});
		assertEquals(response, "[1]");
		
		response = manager.executeCommand(new String[]{ParkingCommands.SLOTS_NUMBER_FOR_REGISTRATION_NUMBER.getValue(), "BATA"});
		assertEquals(response, ParkingConstants.NOT_FOUND);
		
		/**** FETCH  - SLOTS_NUMBER_FOR_CARS_WITH_COLOR ***/
		response = manager.executeCommand(new String[]{ParkingCommands.SLOTS_NUMBER_FOR_CARS_WITH_COLOR.getValue(), "White"});
		assertEquals(response, "[1, 2]");

		response = manager.executeCommand(new String[]{ParkingCommands.SLOTS_NUMBER_FOR_CARS_WITH_COLOR.getValue(), "Blue"});
		assertEquals(response, ParkingConstants.NOT_FOUND);
		
		manager.executeCommand(new String[]{ParkingCommands.RESET.getValue()});

	}
	
	

}
