package com.cabBookingMangementSystem.ErrorDetails;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDate timestamp;
	private String message;
	
	
}
