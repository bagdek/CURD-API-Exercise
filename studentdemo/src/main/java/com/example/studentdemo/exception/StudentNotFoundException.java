package com.example.studentdemo.exception;

@SuppressWarnings("serial")
public class StudentNotFoundException extends Exception {
	public StudentNotFoundException(String message) 
	{
		super(message);
	}
}
