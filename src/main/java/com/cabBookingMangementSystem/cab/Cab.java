package com.cabBookingMangementSystem.cab;

import java.util.List;

import com.cabBookingMangementSystem.booking.Booking;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cab {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cabId;
    
    private String licensePlate;
    private String model;
    private String driverName;
    private String driverContact;
	
    @JsonIgnore
    @OneToMany(mappedBy = "cab")
    private List<Booking> bookings;
}
