package com.gojek.parking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gojek.parking.constant.ParkingCommands;
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
		System.out.println(ParkingConstants.NEW_LINE);
		System.out.println(ParkingConstants.HEADER_LINE);
		System.out.println(ParkingConstants.HEADER_TEXT);
		System.out.println(ParkingConstants.HEADER_LINE);
		System.out.println(ParkingConstants.NEW_LINE);
		
		/*** Print Application COMMAND DETAILS ***/
		printActionCommandDetails();

		while (true) {
			
			try {
				
				
				/***Initialisation of Buffered READER Object to Get the Input of from Console. */
				messageReader = new BufferedReader(new InputStreamReader(System.in));
				String input = messageReader.readLine().trim();
				String array [] = input.split(ParkingConstants.SPACE);

				
				printActionCommandDetails();

				if(null == input) {
					
					/**** CHECK1 - If Command not Entered - Throw Exception***/
					throw new ParkingException(ParkingConstants.NO_COMMAND_ENTERED);

				} else if (input.equalsIgnoreCase(ParkingCommands.EXIT.getValue())) {

					/**** CHECK2 - If Command is EXIT - Then close the stream ***/
					break;
					
				} else if (input.equalsIgnoreCase(ParkingCommands.HELP.getValue())) {

					/**** CHECK3 - HELP - Print the Command Details ***/
					printActionCommandDetails();
					
				} else if(commandManager.isValidCommandEntered(array)) { 
					
					

					/*****  
					 * CHECK4 - 
					 * 			
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
	
		System.out.println(ParkingConstants.LINE1);
		System.out.println(ParkingConstants.LINE2);
		System.out.println(ParkingConstants.LINE3);
		System.out.println(ParkingConstants.LINE4);
		System.out.println(ParkingConstants.LINE5);
		System.out.println(ParkingConstants.LINE6);
		System.out.println(ParkingConstants.NEW_LINE);
		System.out.println(ParkingConstants.LINE7);
		System.out.println(ParkingConstants.LINE2);
		System.out.println(ParkingConstants.LINE8);
		System.out.println(ParkingConstants.LINE9);
		System.out.println(ParkingConstants.LINE10);
		System.out.println(ParkingConstants.LINE11);
		System.out.println(ParkingConstants.LINE12);
	}
	
}
