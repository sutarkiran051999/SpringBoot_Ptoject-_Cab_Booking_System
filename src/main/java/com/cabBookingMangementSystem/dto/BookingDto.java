package com.cabBookingMangementSystem.dto;

import java.util.Date;

import com.cabBookingMangementSystem.cab.Cab;
import com.cabBookingMangementSystem.customer.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

	private Long bookingId;
	private String pickUpLocation;
	private String dropOffLocation;
	private String status;
	private Date bookingDate;
    private Customer customer;
    private Cab cab;
	
}
