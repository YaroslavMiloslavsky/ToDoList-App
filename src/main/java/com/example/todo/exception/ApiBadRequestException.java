package com.example.todo.exception;

@SuppressWarnings("serial")
public class ApiBadRequestException extends RuntimeException {
	public ApiBadRequestException() {
        super();
    }
    public ApiBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
    public ApiBadRequestException(String message) {
        super(message);
    }
    public ApiBadRequestException(Throwable cause) {
        super(cause);
    }
}
