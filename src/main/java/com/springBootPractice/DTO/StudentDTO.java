package com.springBootPractice.DTO;



import com.springBootPractice.entity.Address;

import lombok.Data;

@Data
public class StudentDTO {

	
	private long studentId;
	
	private String studentName;
	
	private int studentRollNumber;
	
	private long studentPhoneNumber;
	
	private Address Studentaddress;
	
}
