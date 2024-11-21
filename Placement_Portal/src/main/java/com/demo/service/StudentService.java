package com.demo.service;

import java.util.List;

import com.demo.entity.Student;
import com.demo.exception.StudentNotFoundException;

public interface StudentService {
	// Create a new student
	Student addStudent(Student student);
	
    // Retrieve a student by ID
    Student getStudentById(int id) throws StudentNotFoundException;

    // Retrieve all students
    List<Student> getAllStudents();

    
    
}
