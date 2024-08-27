package com.cabBookingMangementSystem.globalHandlerException;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cabBookingMangementSystem.ErrorDetails.ErrorDetails;
import com.cabBookingMangementSystem.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	 @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex) {
	        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage());
	        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	    }
	
}