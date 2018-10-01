package com.danielrocha.restapijava.exception;

@SuppressWarnings("serial")
public class BookNotFoundException extends RuntimeException {

	public BookNotFoundException(String exception) {
		super(exception);
	}
	
}
