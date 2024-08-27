package com.cabBookingMangementSystem.dto;

import java.util.Date;
import java.util.List;

import com.cabBookingMangementSystem.booking.Booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

	private long customerId;
	private String customerName;
	private String phoneNumber;
	private String email;
	private Date registeredDate;
	private List<Booking> bookings;
	
}
