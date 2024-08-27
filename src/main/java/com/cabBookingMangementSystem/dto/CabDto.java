package com.cabBookingMangementSystem.dto;

import java.util.List;

import com.cabBookingMangementSystem.booking.Booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CabDto {
	
    private Long cabId;
    private String licensePlate;
    private String model;
    private String driverName;
    private String driverContact;
    private List<Booking> bookings;
	
}
