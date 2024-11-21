package com.demo.exception;

public class JobPostingNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public JobPostingNotFoundException(String message) {
        super(message);
    }
}
