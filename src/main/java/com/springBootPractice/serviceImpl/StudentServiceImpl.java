package com.springBootPractice.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBootPractice.DTO.StudentDTO;
import com.springBootPractice.entity.Student;
import com.springBootPractice.repository.StudentRepository;
import com.springBootPractice.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentRepository studentRepository;

//    Converting DTO TO ENTITY
    
    public List<StudentDTO> convertToDTOList(List<Student> studentList) {
           List<StudentDTO> studentDTOList = new ArrayList<>();
        
        for (Student student : studentList) {
            StudentDTO studentDto = new StudentDTO();
            studentDto.setStudentId(student.getStudentId());
            studentDto.setStudentName(student.getStudentName());
            studentDto.setStudentaddress(student.getStudentaddress());
            studentDto.setStudentRollNumber(student.getStudentRollNumber());
            studentDto.setStudentPhoneNumber(student.getStudentPhoneNumber());
            studentDTOList.add(studentDto);
        }

        return studentDTOList;
    }
    
//  Converting ENTITY   TO DTO

    public Student convertToEntity(StudentDTO studentDto) {
        Student student = new Student();
        student.setStudentId(studentDto.getStudentId());
        student.setStudentaddress(studentDto.getStudentaddress());
        student.setStudentName(studentDto.getStudentName());
        student.setStudentPhoneNumber(studentDto.getStudentPhoneNumber());
        student.setStudentRollNumber(studentDto.getStudentRollNumber());

        return student;
    }

    @Override
    public StudentDTO postDetailsStudents(Student studentDetails) {
        Student student = studentRepository.save(studentDetails);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setStudentId(student.getStudentId());
        studentDTO.setStudentName(student.getStudentName());
        studentDTO.setStudentPhoneNumber(student.getStudentPhoneNumber());
        studentDTO.setStudentRollNumber(student.getStudentRollNumber());
        studentDTO.setStudentaddress(student.getStudentaddress());

        return studentDTO;
    }

    @Override
    public StudentDTO getDetailsStudents(Long studentId) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);

        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudentId(student.getStudentId());
            studentDTO.setStudentName(student.getStudentName());
            studentDTO.setStudentPhoneNumber(student.getStudentPhoneNumber());
            studentDTO.setStudentRollNumber(student.getStudentRollNumber());
            studentDTO.setStudentaddress(student.getStudentaddress());

            return studentDTO;
        }

        return null;
    }

    @Override
    public List<StudentDTO> getAllDetailsStudent() {
        List<Student> studentList = studentRepository.findAll();
        return convertToDTOList(studentList);
    }

    @Override
    public StudentDTO updateDetailsOfStudent(Student update, long studentId) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);

        if (studentOpt.isPresent()) {
            Student getStudent = studentOpt.get();
            getStudent.setStudentName(update.getStudentName());
            getStudent.setStudentaddress(update.getStudentaddress());
            getStudent.setStudentPhoneNumber(update.getStudentPhoneNumber());
            getStudent.setStudentRollNumber(update.getStudentRollNumber());

            Student updatedStudent = studentRepository.save(getStudent);

            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudentId(updatedStudent.getStudentId());
            studentDTO.setStudentName(updatedStudent.getStudentName());
            studentDTO.setStudentPhoneNumber(updatedStudent.getStudentPhoneNumber());
            studentDTO.setStudentRollNumber(updatedStudent.getStudentRollNumber());
            studentDTO.setStudentaddress(updatedStudent.getStudentaddress());

            return studentDTO;
        }

        return null;
    }

    @Override
    public Optional<StudentDTO> deleteDetailsOfStudent(long studentId) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);

        if (studentOpt.isPresent()) {
            studentRepository.deleteById(studentId);

            Student student = studentOpt.get();
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudentId(student.getStudentId());
            studentDTO.setStudentName(student.getStudentName());
            studentDTO.setStudentPhoneNumber(student.getStudentPhoneNumber());
            studentDTO.setStudentRollNumber(student.getStudentRollNumber());
            studentDTO.setStudentaddress(student.getStudentaddress());

            return Optional.of(studentDTO);
        }

        return Optional.empty();
    }
}