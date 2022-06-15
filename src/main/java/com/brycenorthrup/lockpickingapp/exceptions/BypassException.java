package com.brycenorthrup.lockpickingapp.exceptions;

public class BypassException extends Exception {
	private static final long serialVersionUID = 1L;
	public BypassException(String message){
		super(message);
	}
	public BypassException(String message, Throwable error){
		super(message, error);
	}
}
