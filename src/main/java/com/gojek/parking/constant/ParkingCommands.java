package com.gojek.parking.constant;

/***
 * ENUM Details of all the commands
 * 
 * @author Bhopal Singh
 *
 */
public enum ParkingCommands {

	PARK("park"), LEAVE("leave"), STATUS("status"), CREATE_PARKING_LOT(
			"create_parking_lot"), REGISTRATION_NUMBER_FOR_CARS_WITH_COLOR(
					"registration_numbers_for_cars_with_colour"), SLOTS_NUMBER_FOR_REGISTRATION_NUMBER(
							"slot_number_for_registration_number"), SLOTS_NUMBER_FOR_CARS_WITH_COLOR(
									"slot_numbers_for_cars_with_colour");

	private final String value;

	ParkingCommands(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}
}
