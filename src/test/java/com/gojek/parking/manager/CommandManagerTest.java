package com.gojek.parking.manager;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gojek.parking.constant.ParkingCommands;
import com.gojek.parking.exception.ParkingException;

public class CommandManagerTest {

	CommandManager manager = CommandManager.getInstance();
	
	@Before
	public void before() {
		//TODO;
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
		assertEquals(true, result);
		
		/**** PARK ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.PARK.getValue(),"TATA"});
		assertEquals(true, result);

		/**** LEAVE ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.LEAVE.getValue()});
		assertEquals(true, result);
		
		/**** STATUS ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.STATUS.getValue(), "Test"});
		assertEquals(true, result);

		/**** HELP ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.HELP.getValue(), "ADA"});
		assertEquals(true, result);

		/**** RESET ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.RESET.getValue(),"AAA"});
		assertEquals(true, result);
		
		/**** FETCH  - REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR.getValue()});
		assertEquals(true, result);

		/**** FETCH  - SLOTS_NUMBER_FOR_REGISTRATION_NUMBER ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.SLOTS_NUMBER_FOR_REGISTRATION_NUMBER.getValue()});
		assertEquals(true, result);
		
		/**** FETCH  - SLOTS_NUMBER_FOR_CARS_WITH_COLOR ***/
		result = manager.isValidCommandEntered(new String[]{ParkingCommands.SLOTS_NUMBER_FOR_CARS_WITH_COLOR.getValue()});
		assertEquals(true, result);

		/*** INVALID WITH DUMMY **/
		result = manager.isValidCommandEntered(new String[]{"",""});
		assertEquals(false, result);
		
	}

}
