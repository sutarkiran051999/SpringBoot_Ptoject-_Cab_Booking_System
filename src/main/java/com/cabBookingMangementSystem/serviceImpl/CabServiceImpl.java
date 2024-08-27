package com.cabBookingMangementSystem.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabBookingMangementSystem.cab.Cab;
import com.cabBookingMangementSystem.dto.CabDto;
import com.cabBookingMangementSystem.repository.CabRepository;
import com.cabBookingMangementSystem.service.CabService;

@Service
public class CabServiceImpl implements CabService{

	@Autowired
	public CabRepository cabRepository;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Override
	public CabDto postCabDetails(CabDto cabDto) {
		
		Cab cab = modelMapper.map(cabDto, Cab.class);
		Cab cabs = this.cabRepository.save(cab);
		return modelMapper.map(cabs, CabDto.class);
	}

	@Override
	public CabDto getCabDetail(Long cabId) {
		Optional<Cab> cab = this.cabRepository.findById(cabId);
		
		return this.modelMapper.map(cab.get(), CabDto.class);
	}

	@Override
	public List<CabDto> getAllCabDetails() {
		List<Cab>  cab = this.cabRepository.findAll();
		List<CabDto> cabDto = new ArrayList<>();
		
		for(Cab cabObj : cab)
		{
			cabDto.add(modelMapper.map(cabObj, CabDto.class));
		}
		return cabDto;
	}

	@Override
	public CabDto updateCabDetails(CabDto cabsDto, Long cabId) {
		
		Optional<Cab> cab = this.cabRepository.findById(cabId);
		Cab cabss = new Cab();
		if(cab!= null)
		{
			Cab update = cab.get();
			update.setDriverContact(cabsDto.getDriverContact());
			update.setDriverName(cabsDto.getDriverName());
			update.setModel(cabsDto.getModel());
			cabss = cabRepository.save(update);
		}
		return modelMapper.map(cabss,CabDto.class);
	}

	@Override
	public CabDto deletecabDetails(Long cabId) {
		Optional<Cab> cab = this.cabRepository.findById(cabId);
		if(cab.isPresent())
		{
		 this.cabRepository.deleteById(cabId);
		}
		return modelMapper.map(cab.get(), CabDto.class);
		
	}

	

}
