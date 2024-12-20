package com.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.demo.entity.Student;
import com.demo.exception.StudentNotFoundException;
import com.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {

    @Autowired
    private StudentService studService;

    // Add a new student
    @PostMapping("/studentAdd")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        Student createdStudent = studService.addStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatusCode.valueOf(201));
    }

    // Retrieve a student by ID
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) throws StudentNotFoundException {
        Student student = studService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatusCode.valueOf(200));
    }

    // Retrieve all students
    @GetMapping("/allstudents")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatusCode.valueOf(200));
    }

    // Update a student's details by ID
    @PutMapping("/studentUpdate/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @Valid @RequestBody Student updatedStudent) throws StudentNotFoundException {
        // Call the service to update the student
        Student updated = studService.updateStudent(id, updatedStudent);
        return new ResponseEntity<>(updated, HttpStatusCode.valueOf(200));
    }

    // Delete a student by ID
    @DeleteMapping("/studentDelete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) throws StudentNotFoundException {
        // Call the service to delete the student
        studService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(204)); // No content response
    }
    
    @GetMapping("/studentsByName/{name}")
    public ResponseEntity<List<Student>> getStudentsByName(@PathVariable String name) {
        List<Student> students = studService.findStudentsByName(name);
        return ResponseEntity.ok(students);
    }
    
 // Endpoint to get all students sorted by CGPA
    @GetMapping("/StudentsortedByDescCgpa")
    public List<Student> getAllStudentsSortedByCgpa() {
        return studService.getAllStudentsSortedByCgpa();
    }
 
}
