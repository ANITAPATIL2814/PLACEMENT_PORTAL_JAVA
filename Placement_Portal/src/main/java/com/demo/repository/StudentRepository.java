package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	// Find students by their name
    List<Student> findByStudName(String studName);
    
 // Custom query method to find all students sorted by CGPA in descending order
    List<Student> findAllByOrderByStudCgpaDesc();
}
