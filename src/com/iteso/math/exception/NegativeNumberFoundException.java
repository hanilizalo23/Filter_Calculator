package com.iteso.math.exception;

public class NegativeNumberFoundException extends Exception {

	private double negativeNumber;
	public NegativeNumberFoundException(double negativeNumber) {
		super("NegativeNumberFoundException");
		this.negativeNumber=negativeNumber;
	}
	
	public String toString(){
		return getMessage() + "\nNegative number found: " +   this.negativeNumber;
	}
	
}
