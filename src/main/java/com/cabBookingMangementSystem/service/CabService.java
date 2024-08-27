package com.cabBookingMangementSystem.service;

import java.util.List;

import com.cabBookingMangementSystem.dto.CabDto;

public interface CabService{

	public CabDto postCabDetails(CabDto cabDto);
	public CabDto getCabDetail(Long cabId);
	public List<CabDto> getAllCabDetails();
	public CabDto updateCabDetails(CabDto cabs,Long cabId);
	public CabDto deletecabDetails(Long cabId);
}
