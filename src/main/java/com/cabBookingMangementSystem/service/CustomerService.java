package com.cabBookingMangementSystem.service;

import java.util.List;
import java.util.Optional;

import com.cabBookingMangementSystem.customer.Customer;
import com.cabBookingMangementSystem.dto.CustomerDto;

public interface CustomerService {
	public CustomerDto postAllDetailsOfDetails(CustomerDto customers);

	public CustomerDto getDetailOfCustomer(Long customerId);

	public List<CustomerDto> getAllDetailsOfCustomers();

	public CustomerDto updateTheDetailOfCustomer(CustomerDto customers, Long customerId);

	public CustomerDto deletTheDetailsOfCustomer(Long customerId);

}
