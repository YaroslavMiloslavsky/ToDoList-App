package com.example.todo.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

	private final String timeZone = "Asia/Jerusalem";
	
	//404 - not found
	@ExceptionHandler(value = {ApiNotFoundException.class})
	public ResponseEntity<Object> handleApiNotFoundException(ApiNotFoundException exception)
	{
		final HttpStatus notFound = HttpStatus.NOT_FOUND;
		ApiException apiException = new ApiException(exception.getMessage(), exception , notFound, ZonedDateTime.now(ZoneId.of(timeZone)));
		return new ResponseEntity<>(apiException, notFound);
	}
	
	//400 - bad request
	@ExceptionHandler(value = {ApiBadRequestException.class})
	public ResponseEntity<Object> handleApiBadRequestException(ApiBadRequestException exception)
	{
		final HttpStatus badRequest = HttpStatus.BAD_REQUEST;
		ApiException apiException = new ApiException(exception.getMessage() , exception , badRequest , ZonedDateTime.now(ZoneId.of(timeZone)));
		return new ResponseEntity<>(apiException , badRequest);
	}
}
