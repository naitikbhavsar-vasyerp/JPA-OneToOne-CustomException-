package com.springtut.servicecenter.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VehicalNotFoundException extends RuntimeException {public VehicalNotFoundException(String message) {
		super(message);
	}

}
