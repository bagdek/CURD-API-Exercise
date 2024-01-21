package com.example.studentdemo.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.studentdemo.converter.StudentConverter;
import com.example.studentdemo.dao.StudentDao;
import com.example.studentdemo.dto.StudentDto;
import com.example.studentdemo.entity.Student;
import com.example.studentdemo.service.StudentService;


@Component
public class StudentServiceIml implements StudentService {
	@Autowired
    private StudentDao studentDao;
    
    @Autowired
    private StudentConverter studentConverter;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = studentConverter.convertToStudentEntity(studentDto);
        student = studentDao.save(student);
        return studentConverter.convertToStudentDto(student);
    }

    @Override
    public StudentDto getStudentById(int id) {
    	Student student = studentDao.findById(id).orElse(null);
        return studentConverter.convertToStudentDto(student);
    }

    @Override
    public StudentDto updateStudent(int id, StudentDto studentDto) {
        Student student = studentConverter.convertToStudentEntity(studentDto);
        student.setId(id);
        student = studentDao.save(student);
        return studentConverter.convertToStudentDto(student);
    }

    @Override
    public String deleteStudent(int id) {
    	studentDao.deleteById(id);
        return "Student with ID " + id + " has been deleted successfully.";
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentDao.findAll();
        return studentConverter.convertToStudentDtoList(students);
    }
}
