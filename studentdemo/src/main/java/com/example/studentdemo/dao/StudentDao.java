package com.example.studentdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.studentdemo.entity.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
	Student findStudentById(int id);
}
