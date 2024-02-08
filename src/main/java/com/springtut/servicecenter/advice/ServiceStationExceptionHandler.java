package com.springtut.servicecenter.advice;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springtut.servicecenter.dto.ResponseDto;
import com.springtut.servicecenter.exception.JobCardNotFoundException;
import com.springtut.servicecenter.exception.VehicalNotFoundException;

@RestControllerAdvice
public class ServiceStationExceptionHandler {
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {JobCardNotFoundException.class})
	public ResponseDto handleJobCardNotFound(JobCardNotFoundException jobCardNotFoundException) {
		return new ResponseDto(404, jobCardNotFoundException.getMessage(), jobCardNotFoundException.getStackTrace());
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {VehicalNotFoundException.class})
	public ResponseDto handleVehicalNotFound(VehicalNotFoundException vehicalNotFoundException) {
		return new ResponseDto(404, vehicalNotFoundException.getMessage(), vehicalNotFoundException.getStackTrace());
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = {IOException.class})
	public ResponseDto handleIOException(IOException ioException) {
		return new ResponseDto(500, ioException.getMessage(), ioException.getStackTrace());
	}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = {Exception.class})
	public ResponseDto handleGeneralException(Exception exception) {
		return new ResponseDto(500, exception.getMessage(), exception.getStackTrace());
	}
}
