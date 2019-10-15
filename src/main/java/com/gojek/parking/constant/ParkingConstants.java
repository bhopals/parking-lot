package com.gojek.parking.constant;

public class ParkingConstants {
	
	/*** STRING Constants ***/
	public static final String SPACE = " ";
	public static final String REPLACER = "##";
	public static final String NEW_LINE = "\n";
	public static final String DOUBLE_SPACER = "       ";
	public static final String EMPTY = "";
	public static final String NOT_FOUND = "Not Found";
	public static final String NO_COMMAND_ENTERED = "No Parameter Passed";
	public static final String NO_SLOT_FOUND= "No slots found";
	
	public static final String SLOT_STATUS_HEADER = "Slot No.  Reg.No.  	 Color ";
	public static final String SLOT_HEADER_SEP = "------------------------------------------------------------";
	
	/*** STRING EXCEPTION CONSTANTS ***/
	public static final String RESERVE_SLOT_SUCCESS = "Allocated slot number: ##.";
	public static final String RESERVE_SLOT_ERROR = "Sorry, parking lot is full.";
	
	public static final String UNRESERVE_SLOT_SUCCESS = "Slot number ## is free.";
	public static final String UNRESERVE_SLOT_ERROR = "Parking spot:## is already vacant!!!.";
	public static final String UNRESERVE_SLOT_INVALID_INDEX= "Invalid parking spot index entered.";


	public static final String INVALID_COMMAND = "No Command Found: ##";
	public static final String INVALID_COMMAND_PARAM = "Missing Parameters in command: ##";
	
	
	public static final String INIT_ERROR = "Parking Lot in not initilized. Kindly run 'create_parking_log' <number> command.";
	
	public static final String CREATE_SUCCESS = "Created a parking lot with ## slots";
	public static final String CREATE_ERROR = "Parking Manager Already Exists. Kindly run 'RESET' to delete existing and then try creating again.";
	
	public static final String DELETE_SUCCESS = "Parking Lot deleted Successfully";
	public static final String DELETE_ERROR = "Error in Deletion of Parking Lot";


	/**** OTHERS ****/
	public static final String STRING_404 = "You should not be here!!!";
	public static final String CURRENT_STATUS_START = "----current status start -----";
	public static final String CURRENT_STATUS_END = "----current status end -----";
	
	
	public static final String HEADER_LINE ="************************************************************************";
	public static final String HEADER_TEXT ="**************************  WELCOME TO PARKING APP *********************";
	
	/**** INTRO INFORMATION ****/
	public static final String LINE1 = "A. Commands for Parking Actions";
	public static final String LINE2 = "----------------------------------------------------------";
	public static final String LINE3 = "1. Parking Initialization ==> create_parking_lot <NUMBER>";
	public static final String LINE4 = "2. Park the Car ==> park <car_number> <CAR_COLOR>";
	public static final String LINE5 = "3. Unpark the Car	==> leave <PARKING_SLOT_NUMBER>";
	public static final String LINE6 = "4. Rest the Parking Lot ==> reset";
	public static final String LINE7 = "B. Commands to Query Details";
	public static final String LINE8 = "1. Parking Lot current status ==> status";
	public static final String LINE9 = "2. Fetch registerd cars by car color ==> registration_numbers_for_cars_with_color <CAR_COLOR>";
	public static final String LINE10 = "3. Fetch parking number of entered color cars ==> slot_numbers_for_cars_with_color <CAR_COLOR>";
	public static final String LINE11 = "4. Fetch parking number by car reg. number ==> slot_number_for_registration_number <CAR_NUMBER>";
	public static final String LINE12 = "Please enter your input:";


}

