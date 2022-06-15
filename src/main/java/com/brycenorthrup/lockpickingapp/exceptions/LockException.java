package com.brycenorthrup.lockpickingapp.exceptions;

public class LockException extends Exception {
	private static final long serialVersionUID = 1L;
	public LockException(String message){
		super(message);
	}
	public LockException(String message, Throwable error){
		super(message, error);
	}
}
