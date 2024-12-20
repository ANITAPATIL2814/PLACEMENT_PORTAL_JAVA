package com.demo.serviceimpl;

import com.demo.entity.Student;
import com.demo.exception.StudentNotFoundException;
import com.demo.repository.StudentRepository;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int id) throws StudentNotFoundException {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(int id, Student updatedStudent) throws StudentNotFoundException {
        // Find the student by ID or throw exception if not found
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));

        // Update student details
        student.setStudName(updatedStudent.getStudName());
        student.setStudEmail(updatedStudent.getStudEmail());
        student.setStudphone(updatedStudent.getStudphone());

        // Save and return the updated student
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) throws StudentNotFoundException {
        // Find the student by ID or throw exception if not found
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));

        // Delete the student
        studentRepository.delete(student);
    }
    
    //get student by name
    @Override
    public List<Student> findStudentsByName(String studName) {
        return studentRepository.findByStudName(studName);
    }
    
    @Override
    public List<Student> getAllStudentsSortedByCgpa() {
        // Using the custom repository method to get students sorted by CGPA in descending order
        return studentRepository.findAllByOrderByStudCgpaDesc();
    }
}
