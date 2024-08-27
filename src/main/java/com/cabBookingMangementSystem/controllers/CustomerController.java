package com.cabBookingMangementSystem.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cabBookingMangementSystem.dto.CustomerDto;
import com.cabBookingMangementSystem.serviceImpl.CustomerServiceImpl;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	public ModelMapper modelMapper;

	@Autowired
	public CustomerServiceImpl customerServiceimpl;
	
	@PostMapping("/saves")
	public CustomerDto saveDetailsOfCustomer(@RequestBody CustomerDto customer)
	{
		CustomerDto savingAlldetails = this.customerServiceimpl.postAllDetailsOfDetails(customer);
		return savingAlldetails;
	}
	
	@GetMapping("/getting/{customerId}")
	public CustomerDto gettingDetailsOfCustomer(@PathVariable Long customerId)
	{
	    CustomerDto gettingDetails = this.customerServiceimpl.getDetailOfCustomer(customerId);
		return gettingDetails;
	}
	
	@GetMapping("/getAll")
    public List<CustomerDto> gettingAllDetailsOfCustomer()
    {
		List<CustomerDto> gettingAllCustomerDetail = this.customerServiceimpl.getAllDetailsOfCustomers();
		return gettingAllCustomerDetail;
    }
	
	@PutMapping("/update/{customerId}")
	public CustomerDto updateDetailOfCustomer(@RequestBody CustomerDto customersDto , @PathVariable Long customerId)
	{
		CustomerDto updateDetailCustomer = this.customerServiceimpl.updateTheDetailOfCustomer(customersDto, customerId); 
		return updateDetailCustomer;
	}
	
	@DeleteMapping("/delete/{customerId}")
	
	public CustomerDto deleteCustomerDetail(@PathVariable Long customerId)
	{
		CustomerDto customerDto = this.deleteCustomerDetail(customerId);
		return customerDto;
	}
	
}
