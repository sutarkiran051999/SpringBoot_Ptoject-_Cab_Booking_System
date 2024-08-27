package com.cabBookingMangementSystem.service;

import java.util.List;
import java.util.Optional;

import com.cabBookingMangementSystem.booking.Booking;
import com.cabBookingMangementSystem.dto.BookingDto;

public interface BookingService{

	public BookingDto postBookingDetails(BookingDto bookingsDto);
	public BookingDto getBookingDetails(Long bookingId);
	public List<BookingDto> getAllBookingDetails();
	public BookingDto updateBookingDetails(BookingDto bookings,Long bookingId);
	public BookingDto deleteBooking(Long bookingId); 
}
