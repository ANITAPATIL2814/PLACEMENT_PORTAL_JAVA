package com.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler {
		// Handles CompanyNotFoundException and returns a 404 status with an error message.
		 @ExceptionHandler(CompanyNotFoundException.class)
	    public ResponseEntity<ErrorMessage> handleCompanyNotFoundException(CompanyNotFoundException pe,
	            WebRequest request) {
	        // Create error message with 404 status code and exception message
	        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND.value(), pe.getMessage());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
	    }
		// Handles JobPostingNotFoundException and returns a 404 status with an error message.
		 @ExceptionHandler(JobPostingNotFoundException.class)
	    public ResponseEntity<ErrorMessage> handleJobPostingNotFoundException(JobPostingNotFoundException pe,
	            WebRequest request) {
	        // Create error message with 404 status code and exception message
	        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND.value(), pe.getMessage());
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
	    }
		 
		// Handles LabTestNotFoundException and returns a 404 status with an error message.
			 @ExceptionHandler(PlacementDriveNotFoundException.class)
		    public ResponseEntity<ErrorMessage> handlePlacementDriveNotFoundException(PlacementDriveNotFoundException pe,
		            WebRequest request) {
		        // Create error message with 404 status code and exception message
		        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND.value(), pe.getMessage());
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
		    }
			 
			// Handles StudentNotFoundException and returns a 404 status with an error message.
			 @ExceptionHandler(StudentNotFoundException.class)
		    public ResponseEntity<ErrorMessage> handleStudentNotFoundException(StudentNotFoundException pe,
		            WebRequest request) {
		        // Create error message with 404 status code and exception message
		        ErrorMessage em = new ErrorMessage(HttpStatus.NOT_FOUND.value(), pe.getMessage());
		        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(em);
		    }

	
				 
}
