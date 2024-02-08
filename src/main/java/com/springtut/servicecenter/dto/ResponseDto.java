package com.springtut.servicecenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ResponseDto {
	
	private int status;
	private String message;
	private Object object;
	public ResponseDto(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	
	
}
