package com.cabBookingMangementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabBookingMangementSystem.booking.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}
