package com.example.studentdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Student_Details")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Student_ID")
	private int id;
	
	@NotNull(message="Name cannot be null")
	@Column(name = "Student_Name")
	private String name;
	
	@NotBlank (message="Enter gender")
	@Column(name = "Student_Gender")
	private String gender;
	
	@Email(message="Enter proper email")
	@Column(name = "Student_Email")
	private String email;

}
