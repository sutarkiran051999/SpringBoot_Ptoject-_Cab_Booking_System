package com.cabBookingMangementSystem.customer;

import java.util.Date;
import java.util.List;

import com.cabBookingMangementSystem.booking.Booking;
import com.cabBookingMangementSystem.cab.Cab;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;
	private String customerName;
	private String phoneNumber;
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date registeredDate;
	
	
	@JsonIgnore
	 @OneToMany(mappedBy = "customer")
	 private List<Booking> bookings;
	
}
