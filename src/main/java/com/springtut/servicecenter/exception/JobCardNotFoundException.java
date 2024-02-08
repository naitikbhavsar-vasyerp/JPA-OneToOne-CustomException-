package com.springtut.servicecenter.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class JobCardNotFoundException extends RuntimeException{

	public JobCardNotFoundException(String message) {
		super(message);
	}
	
	
}
