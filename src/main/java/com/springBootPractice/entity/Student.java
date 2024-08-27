package com.springBootPractice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "Student_Information")
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "Id")
	private long studentId;
	
	@Column(name = "Name")
	private String studentName;
	
	@Column(name = "Roll_No")
	private int studentRollNumber;
	
	@Column(name = "Phone_NO")
	private long studentPhoneNumber;

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "addressId",name = "address_id")
	private Address Studentaddress;
	
	
}
