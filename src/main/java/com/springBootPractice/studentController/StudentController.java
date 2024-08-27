package com.springBootPractice.studentController;

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

import com.springBootPractice.DTO.StudentDTO;
import com.springBootPractice.DTO.StudentDTO;
import com.springBootPractice.entity.Address;
import com.springBootPractice.entity.Student;
import com.springBootPractice.serviceImpl.StudentServiceImpl;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	public StudentServiceImpl studentServiceImpl;
	
	@PostMapping("/post")
	public StudentDTO postStudentDetails(@RequestBody Student studentdetail)
	{
		StudentDTO student = studentServiceImpl.postDetailsStudents(studentdetail);
		return student;	
	}
	
	@GetMapping("/get/{studentId}")
	public StudentDTO getStudentDetails(@PathVariable long studentId)
	{
		StudentDTO student = studentServiceImpl.getDetailsStudents(studentId);
		return student;
	}
	
	@GetMapping("/getAll")
    public List<StudentDTO> getAllDetailsOfStudent()
    {
		List<StudentDTO> student = studentServiceImpl.getAllDetailsStudent();
		return student;
    }
	
	@PutMapping("/update/{studentId}")
	public StudentDTO updateStudentDetail(@RequestBody Student studentDetail,@PathVariable long studentId)
	{
		StudentDTO student = studentServiceImpl.updateDetailsOfStudent(studentDetail,studentId);
	    return student;
		
	}
	
	@DeleteMapping("/delete/{studentId}")
	public Optional<StudentDTO> deleteStudentDetail(@PathVariable long studentId)
	{
		Optional<StudentDTO> student = studentServiceImpl.deleteDetailsOfStudent(studentId);
		return student;
		
	}
	
}
