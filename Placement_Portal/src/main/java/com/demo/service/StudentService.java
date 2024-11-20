package com.demo.service;

import java.util.List;

import com.demo.entity.Student;

public interface StudentService {
	// Create a new student
	Student addStudent(Student student);
	
    // Retrieve a student by ID
    Student getStudentById(int id);

    // Retrieve all students
    List<Student> getAllStudents();

    // Update student details
//    void updateStudent(Student student);

    
}
