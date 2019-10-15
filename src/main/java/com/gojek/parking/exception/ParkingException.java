package com.gojek.parking.exception;

public class ParkingException extends Exception {
	
	private static final long serialVersionUID = 1L;

	private String errorDetails;
	
	public ParkingException(String errorDetails) {
		super(errorDetails);
		this.errorDetails = errorDetails;
	}
	
	/**
	 * @return the errorDetails
	 */
	public String getErrorDetails() {
		return errorDetails;
	}
	/**
	 * @param errorDetails the errorDetails to set
	 */
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
	}
	
	
	/** (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParkingException [ errorDetails=" + errorDetails + "]";
	}
	
	
}
