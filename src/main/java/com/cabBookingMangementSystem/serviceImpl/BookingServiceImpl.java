package com.cabBookingMangementSystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBookingMangementSystem.booking.Booking;
import com.cabBookingMangementSystem.dto.BookingDto;
import com.cabBookingMangementSystem.repository.BookingRepository;
import com.cabBookingMangementSystem.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService{

	@Autowired
	public ModelMapper modelMapper;
	
	@Autowired
	public BookingRepository bookingRepository;
	
	@Override
	public BookingDto postBookingDetails(BookingDto booking2) {
		
		Booking booking = modelMapper.map(booking2,Booking.class);
		Booking saveDetails = this.bookingRepository.save(booking);
		
		return this.modelMapper.map(saveDetails, BookingDto.class);
	}

	@Override
	public BookingDto getBookingDetails(Long bookingId) {
		
		Optional<Booking> booking = this.bookingRepository.findById(bookingId);
		return modelMapper.map(booking.get(), BookingDto.class);
	}

	@Override
	public List<BookingDto> getAllBookingDetails() {
		List<Booking> booking = this.bookingRepository.findAll();
		List<BookingDto> bookingDto = new ArrayList<>();
		
		for(Booking getingAllDetails : booking)
		{
			bookingDto.add(modelMapper.map(getingAllDetails, BookingDto.class));
		}
		return bookingDto;
	}

	@Override
	public BookingDto updateBookingDetails(BookingDto bookingsDto, Long bookingId) {
		
		Optional<Booking> update = this.bookingRepository.findById(bookingId);
		Booking updateDto = new Booking();
		if(update != null)
		{
			Booking modified  = update.get();
			modified.setBookingDate(bookingsDto.getBookingDate());
			modified.setDropOffLocation(bookingsDto.getDropOffLocation());
			modified.setPickUpLocation(bookingsDto.getPickUpLocation());
			modified.setStatus(bookingsDto.getStatus());
			
			Booking updatedAll = this.bookingRepository.save(modified);
		   
		}
		
		return modelMapper.map(updateDto,BookingDto.class);
	}

	@Override
	public BookingDto deleteBooking(Long bookingId)
	{
		Optional<Booking> booking = this.bookingRepository.findById(bookingId);
		
		if(booking.isPresent())
		{
		  bookingRepository.deleteById(bookingId);
		}
		return modelMapper.map(booking, BookingDto.class);

	}

	
	
}
