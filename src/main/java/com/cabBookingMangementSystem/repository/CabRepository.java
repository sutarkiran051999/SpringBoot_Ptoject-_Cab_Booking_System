package com.cabBookingMangementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabBookingMangementSystem.cab.Cab;

@Repository
public interface CabRepository extends JpaRepository<Cab, Long>{

}
