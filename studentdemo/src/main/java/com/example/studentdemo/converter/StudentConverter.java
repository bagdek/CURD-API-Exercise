package com.example.studentdemo.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.studentdemo.dto.StudentDto;
import com.example.studentdemo.entity.Student;

@Component
public class StudentConverter {
	public Student convertToStudentEntity(StudentDto studentDto) {
        Student student = new Student();
        if (studentDto != null) {
        	student.setId(studentDto.getId());
        	student.setName(studentDto.getName());
        	student.setGender(studentDto.getGender());
        	student.setEmail(studentDto.getEmail());
        }
        	return student;
      }
	 public StudentDto convertToStudentDto(Student student) {
	        StudentDto studentDto = new StudentDto();
	        if (student != null) {
	        	studentDto.setId(student.getId());
	        	studentDto.setName(student.getName());
	        	studentDto.setGender(student.getGender());
	        	studentDto.setEmail(student.getEmail());
	        }
	        return studentDto;
	 }
	 public List<StudentDto> convertToStudentDtoList(List<Student> students) {
         return students.stream()
             .map(this::convertToStudentDto)
             .collect(Collectors.toList());
 }

}
