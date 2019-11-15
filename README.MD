
An approach to solve Parking Lot problem.

Tech Stack Used :

Java  8
Maven 3
Ubuntu ( On Docker Image)


RUN:

To Run the program, please run "./parking_lot" command from the home directory of the project.

$.....solution/parking-lot# ./parking_lot


*Kindly ensure you have JAVA/MVN path already set.


*Sample Output*




************************************************************************
**************************  WELCOME TO PARKING APP *********************
************************************************************************


A. Commands for Parking Actions
----------------------------------------------------------
1. Parking Initialization ==> create_parking_lot <NUMBER>
2. Park the Car ==> park <car_number> <CAR_COLOR>
3. Unpark the Car       ==> leave <PARKING_SLOT_NUMBER>
4. Rest the Parking Lot ==> reset


B. Commands to Query Details
----------------------------------------------------------
1. Parking Lot current status ==> status
2. Fetch registerd cars by car color ==> registration_numbers_for_cars_with_color <CAR_COLOR>
3. Fetch parking number of entered color cars ==> slot_numbers_for_cars_with_color <CAR_COLOR>
4. Fetch parking number by car reg. number ==> slot_number_for_registration_number <CAR_NUMBER>


*Sample Output*

	Please enter your input:
	create_parking_lot 5
	Created a parking lot with 5 slots
	park WWW White
	Allocated slot number: 1.
	park GGG Red
	Allocated slot number: 2.
	park AAA Orange
	Allocated slot number: 3.
	park WWW White
	Allocated slot number: 4.
	park WWW Red
	Allocated slot number: 5.
	park GGG Red
	Sorry, parking lot is full.
	status
	Slot No.  Reg.No.        Color
	------------------------------------------------------------
	1       WWW       White
	2       GGG       Red
	3       AAA       Orange
	4       WWW       White
	5       WWW       Red
	------------------------------------------------------------
	leave 5
	Slot number 5 is free.
	leave 7
	Invalid parking spot index entered.
	leave -1
	Invalid parking spot index entered.
	leave 4
	Slot number 4 is free.
	status
	Slot No.  Reg.No.        Color
	------------------------------------------------------------
	1       WWW       White
	2       GGG       Red
	3       AAA       Orange
	------------------------------------------------------------
	leave 1
	Slot number 1 is free.
	leave 2
	Slot number 2 is free.
	park TTT ddd
	Allocated slot number: 1.
	status
	Slot No.  Reg.No.        Color
	------------------------------------------------------------
	1       TTT       ddd
	3       AAA       Orange
	------------------------------------------------------------
	exit