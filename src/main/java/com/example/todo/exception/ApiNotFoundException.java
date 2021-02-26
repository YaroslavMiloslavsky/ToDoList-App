package com.example.todo.exception;

@SuppressWarnings("serial")
public class ApiNotFoundException extends RuntimeException {
	 public ApiNotFoundException() {
	        super();
	    }
	    public ApiNotFoundException(String message, Throwable cause) {
	        super(message, cause);
	    }
	    public ApiNotFoundException(String message) {
	        super(message);
	    }
	    public ApiNotFoundException(Throwable cause) {
	        super(cause);
	    }
}
