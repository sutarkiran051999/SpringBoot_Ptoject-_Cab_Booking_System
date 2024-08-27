package com.springBootPractice.service;

import java.util.List;
import java.util.Optional;

import com.springBootPractice.DTO.StudentDTO;
import com.springBootPractice.entity.Address;
import com.springBootPractice.entity.Student;

public interface StudentService  {

	public StudentDTO postDetailsStudents(Student studentDetails);
	public StudentDTO getDetailsStudents(Long studentId );	
	public List<StudentDTO> getAllDetailsStudent();
	public StudentDTO updateDetailsOfStudent(Student student,long studentId);
	public Optional<StudentDTO> deleteDetailsOfStudent(long studentId);
	
}
