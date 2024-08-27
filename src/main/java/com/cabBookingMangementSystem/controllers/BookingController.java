package com.cabBookingMangementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabBookingMangementSystem.dto.BookingDto;
import com.cabBookingMangementSystem.serviceImpl.BookingServiceImpl;

@RestController
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	public BookingServiceImpl bookingServiceImpl;
	
	@PostMapping("/post")
	public BookingDto bookingDetailsOffCustomer(@RequestBody BookingDto booking)
	{
		BookingDto bookingInProcesss = this.bookingServiceImpl.postBookingDetails(booking);
		return bookingInProcesss;
	}
	
	@GetMapping("/get/{bookingId}")
	public BookingDto getDetailOffCustomer(@PathVariable Long bookingId)
	{
		BookingDto booking = this.bookingServiceImpl.getBookingDetails(bookingId);
		return booking;
		
	}
	
	@GetMapping("/getAll")
	public BookingDto getAllbookingDetailsOffCustomer() 
	{
		 BookingDto booking = this.getAllbookingDetailsOffCustomer();
		 return booking;
	}
	
	@PutMapping("/update")
	public BookingDto updateTheBookingDetailsOffCustomer(@RequestBody BookingDto booking, @PathVariable Long bookingId)
	{
		BookingDto update = this.bookingServiceImpl.updateBookingDetails(booking, bookingId);
		return update;
	}
	
	@DeleteMapping("/delete")
	public BookingDto deleteDetailsOffBooking(@PathVariable Long bookingId)
	{
		return this.bookingServiceImpl.deleteBooking(bookingId);
		
	}

}
