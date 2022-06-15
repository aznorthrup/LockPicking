package com.brycenorthrup.lockpickingapp.exceptions;

public class PickException extends Exception {
	private static final long serialVersionUID = 1L;
	public PickException(String message){
		super(message);
	}
	public PickException(String message, Throwable error){
		super(message, error);
	}
}
