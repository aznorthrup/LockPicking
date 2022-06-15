package com.brycenorthrup.lockpickingapp.exceptions;

public class TensionException extends Exception {
	private static final long serialVersionUID = 1L;
	public TensionException(String message){
		super(message);
	}
	public TensionException(String message, Throwable error){
		super(message, error);
	}
}
