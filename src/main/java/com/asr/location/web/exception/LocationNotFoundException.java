package com.asr.location.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LocationNotFoundException extends Exception {
	
	
	private static final long serialVersionUID = 1L;

	public LocationNotFoundException(String exceptionMessage) {
		super(exceptionMessage);
	}

}
