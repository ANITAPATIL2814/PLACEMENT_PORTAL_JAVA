package com.demo.service;
import com.demo.entity.Student;
import com.demo.exception.StudentNotFoundException;
import java.util.List;
public interface StudentService {

    // Add a new student
    Student addStudent(Student student);

    // Retrieve a student by ID
    Student getStudentById(int id) throws StudentNotFoundException;

    // Retrieve all students
    List<Student> getAllStudents();

    // Update student's details by ID
    Student updateStudent(int id, Student updatedStudent) throws StudentNotFoundException;

    // Delete a student by ID
    void deleteStudent(int id) throws StudentNotFoundException;
    
    // Retrieve all by name

	List<Student> findStudentsByName(String studName);

	// Method to get all students sorted by CGPA
    List<Student> getAllStudentsSortedByCgpa();
}
