package com.gojek.parking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gojek.parking.constant.ParkingConstants;
import com.gojek.parking.exception.ParkingException;
import com.gojek.parking.manager.CommandManager;

/**
 * Main App - ParkingAPP
 *
 *	This is the MAIN Method and the main executable of the APP.
 */
public class ParkingApp {

	public static void main(String[] args) throws IOException {

		BufferedReader messageReader = null;
		CommandManager commandManager = CommandManager.getInstance();
		
		/*** Welcome BADGE of the Application ***/
		System.out.println("\n");
		System.out.println("************************************************************************");
		System.out.println("**************************  WELCOME TO PARKING APP *********************");
		System.out.println("************************************************************************");
		System.out.println("\n");
		
		/*** Print Application COMMAND DETAILS ***/
		printActionCommandDetails();

		while (true) {
			
			try {
				
				
				/***Initialization of Buffered READER Object to Get the Input of from Console. */
				messageReader = new BufferedReader(new InputStreamReader(System.in));
				String input = messageReader.readLine().trim();
				String array [] = input.split(ParkingConstants.SPACE);
				System.out.println("input:"+input);

				if(null == input) {/*** IF null **/
					throw new ParkingException("No Parameter Passed");
				} else if (input.equalsIgnoreCase("exit")) {/***** If EXIT - Abort the program *****/
					break;
				} else if(commandManager.isValidCommandEntered(array)) { 
					

					/*****  
					 * Read the COMMAND and take ACTION ACCORDINGLY 
					 *
					 * 	Business Logic execution block
					 * 
					 **/					
					commandManager.executeCommand(array);		
					
					
				} 
			} catch (ParkingException e) {
				System.out.println(e.getMessage());
			} finally {
				/*if(null != messageReader) {
					messageReader.close();
				}*/
			}

		}

	}

	/**
	 * To Print Command Details 
	 */
	private static void printActionCommandDetails() {		
		System.out.println("A. Commands for Parking Actions");
		System.out.println("----------------------------------------------------------");
		System.out.println("1. Parking Initialization ==> create_parking_lot <NUMBER>");
		System.out.println("2. Park the Car ==> park <car_number> <CAR_COLOR>");
		System.out.println("3. Unpark the Car	==> leave <PARKING_SLOT_NUMBER>");
		System.out.println("4. Rest the Parking Lot ==> reset");
		System.out.println("\n");
		System.out.println("B. Commands to Query Details");
		System.out.println("----------------------------------------------------------");
		System.out.println("1. Parking Lot current status ==> status");
		System.out.println("2. Fetch registerd cars by car color ==> registration_numbers_for_cars_with_color <CAR_COLOR>");
		System.out.println("3. Fetch parking number of entered color cars ==> slot_numbers_for_cars_with_color <CAR_COLOR>");
		System.out.println("4. Fetch parking number by car reg. number ==> slot_number_for_registration_number <CAR_NUMBER>");
		System.out.println("Please enter your input:");
	}

}
