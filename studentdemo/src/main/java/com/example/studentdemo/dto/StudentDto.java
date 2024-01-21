package com.example.studentdemo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Data
public class StudentDto {
    
	private int id;
	
	@NotNull(message="Name cannot be null")
	private String name;
	
	@NotBlank (message="Enter gender")
	private String gender;
	
	@Email(message="Enter proper email")
	private String email;

}
