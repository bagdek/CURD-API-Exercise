package com.example.studentdemo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentdemo.dto.StudentDto;
import com.example.studentdemo.exception.StudentNotFoundException;
import com.example.studentdemo.service.StudentService;




@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
    private  StudentService studentService;
    
	@GetMapping("/get/all")
    public List<StudentDto> getAllStudents() {
        List<StudentDto> studentDtos = studentService.getAllStudents();
        return studentDtos;
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable int id) throws StudentNotFoundException{
    	StudentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }

    @PostMapping("/createStudent")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto) {
    	StudentDto createdStudent = studentService.createStudent(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable int id, @RequestBody StudentDto studentDto){
    	StudentDto updatedStudent = studentService.updateStudent(id, studentDto);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
