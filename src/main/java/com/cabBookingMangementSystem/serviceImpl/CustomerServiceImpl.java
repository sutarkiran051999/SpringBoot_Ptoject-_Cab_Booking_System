package com.cabBookingMangementSystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBookingMangementSystem.booking.Booking;
import com.cabBookingMangementSystem.customer.Customer;
import com.cabBookingMangementSystem.dto.CustomerDto;
import com.cabBookingMangementSystem.exceptions.ResourceNotFoundException;
import com.cabBookingMangementSystem.repository.CustomerRepository;
import com.cabBookingMangementSystem.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	public ModelMapper modelMapper;
	
	@Autowired
	public CustomerRepository customerRepository;
	
	@Override
	public CustomerDto postAllDetailsOfDetails(CustomerDto customers) {
		
		Customer changingInDto = modelMapper.map(customers,Customer.class);
		Customer customer = this.customerRepository.save(changingInDto);
		
		return modelMapper.map(customer, CustomerDto.class);
	}

	@Override
	public CustomerDto getDetailOfCustomer(Long customerId) {
	    Customer customer = this.customerRepository.findById(customerId)
	        .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));
	    return modelMapper.map(customer, CustomerDto.class);
	}


	@Override
	public List<CustomerDto> getAllDetailsOfCustomers() {
		List<Customer> customer = this.customerRepository.findAll();
		List<CustomerDto> takingCustomerDetailsInCustomerDto = new ArrayList<>();
		
		if(customer.isEmpty())
		{
			throw new  ResourceNotFoundException("Resourese is Not Available");
		}
		for(Customer customerObj : customer)
		{
			 takingCustomerDetailsInCustomerDto.add(modelMapper.map(customerObj,CustomerDto.class));
		}
		return  takingCustomerDetailsInCustomerDto;
	}

	@Override
	public CustomerDto updateTheDetailOfCustomer(CustomerDto customersDto, Long customerId) {
		Optional<Customer> customer = this.customerRepository.findById(customerId);
		
		if(customer!=null)
		{
		   Customer update = customer.get();
		   update.setCustomerName(customersDto.getCustomerName());
		   update.setEmail(customersDto.getEmail());
		   update.setPhoneNumber(customersDto.getPhoneNumber());
		   update.setRegisteredDate(customersDto.getRegisteredDate());
		   update.setBookings(customersDto.getBookings());
		}
		else
		{
			throw new ResourceNotFoundException("Customer not found with id: " + customerId);
		}
		
		return modelMapper.map(customer, CustomerDto.class);
	}

	@Override
	public CustomerDto deletTheDetailsOfCustomer(Long customerId) {
		Optional<Customer> customer = this.customerRepository.findById(customerId);
		
		try {
		if(customer!=null)
		{
			customerRepository.deleteById(customerId);
		}
		}catch(Exception e)
		{
			throw new ResourceNotFoundException("Customer not found with id: " + customerId);
		}
		return modelMapper.map(customer,CustomerDto.class);
	}

}
