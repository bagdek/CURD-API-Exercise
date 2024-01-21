package com.example.studentdemo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.studentdemo.dto.StudentDto;


@Service
public interface StudentService {
	StudentDto createStudent(StudentDto studentDto);
	StudentDto getStudentById(int id);
	StudentDto updateStudent(int id, StudentDto studentDto);
    String deleteStudent(int id);
    List<StudentDto> getAllStudents();

}
