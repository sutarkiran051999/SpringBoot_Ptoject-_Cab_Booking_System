package com.cabBookingMangementSystem.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabBookingMangementSystem.cab.Cab;
import com.cabBookingMangementSystem.dto.CabDto;
import com.cabBookingMangementSystem.serviceImpl.CabServiceImpl;

@RestController
@RequestMapping("/cabs")
public class CabController {
	
	@Autowired
	public CabServiceImpl cabServiceImpl;
	

	@PostMapping("/post")
	public CabDto postCabDetails(@RequestBody CabDto cabs)
	{
		CabDto cab = this.cabServiceImpl.postCabDetails(cabs);
		return cab;
	}
	
	@GetMapping("/get/{cabId}")
	public CabDto getCabDetails(@PathVariable Long cabId)
	{
		CabDto cab = this.cabServiceImpl.getCabDetail(cabId);
		
		return cab;
	}
	
	@GetMapping("/getAll")
	public List<CabDto> getAllDetailsOfCab()
	{
		List<CabDto> cab = this.cabServiceImpl.getAllCabDetails();
		return cab;
	}
	
	@PutMapping("/update/{cabId}")
	public Cab updateCabDetails(@RequestBody Cab cabs,@PathVariable Long cabId)
	{
		Cab cab = this.updateCabDetails(cabs, cabId);
		return cab;
	}
	
	@DeleteMapping("/delete/{cabId}")
	public Cab deleteCabDetails(@PathVariable Long cabId)
	{
		Cab cab = this.deleteCabDetails(cabId);
		return cab;
	}
}
