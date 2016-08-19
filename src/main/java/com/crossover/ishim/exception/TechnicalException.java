package com.crossover.ishim.exception;

public class TechnicalException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TechnicalException(){
		
	}
	
	public TechnicalException(String message){
		super(message);
	}
	
	public TechnicalException(Exception e){
		super(e);
	}
}
