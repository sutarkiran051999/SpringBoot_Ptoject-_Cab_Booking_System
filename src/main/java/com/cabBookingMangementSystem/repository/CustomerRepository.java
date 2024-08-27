package com.cabBookingMangementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabBookingMangementSystem.customer.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
