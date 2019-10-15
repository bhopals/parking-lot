package com.gojek.parking.model;

import java.io.Serializable;

/**
 * @author Bhopal Singh
 * 
 * Model Class Details
 *
 */
public class Car implements Serializable {

	private static final long serialVersionUID = -5406152364580956010L;
	
	private String color;

	private String registrationNumber;
	
	/***
	 * Parametrized Constructor
	 * 
	 * @param color
	 * @param registrationNumber
	 */
	public Car(String registrationNumber, String color) {
		super();
		this.color = color;
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Car [color=" + color + ", registrationNumber=" + registrationNumber + "]";
	}
	

}
