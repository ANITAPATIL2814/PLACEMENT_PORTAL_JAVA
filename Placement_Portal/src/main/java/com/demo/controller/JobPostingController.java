package com.demo.controller;

import com.demo.entity.JobPosting;
import com.demo.exception.JobPostingNotFoundException;
import com.demo.service.JobPostingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

    // Add a new job posting
    @PostMapping("/jobpostingAdd")
    public ResponseEntity<JobPosting> addJobPosting(@RequestBody JobPosting jobPosting) {
        JobPosting createdJobPosting = jobPostingService.addJobPosting(jobPosting);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJobPosting);
    }

    // Retrieve a job posting by ID
    @GetMapping("/jobposting/{id}")
    public ResponseEntity<JobPosting> getJobPostingById(@PathVariable Long id) throws JobPostingNotFoundException {
        JobPosting jobPosting = jobPostingService.getJobPostingById(id);
        return ResponseEntity.ok(jobPosting);
    }

    // Search job postings by job name
    //http://localhost:8080/jobpostingSearch/FullStack
    @GetMapping("/jobpostingSearch/{jobName}")
    public ResponseEntity<List<JobPosting>> searchJobPostingByName(@PathVariable String jobName) {
        List<JobPosting> jobPostings = jobPostingService.searchJobPostingByName(jobName);
        if (jobPostings.isEmpty()) {
            return ResponseEntity.noContent().build();  // 204 No Content if no job postings found
        }
        return ResponseEntity.ok(jobPostings);
    }

    // Retrieve all job postings
    @GetMapping("/jobpostingAll")
    public ResponseEntity<List<JobPosting>> getAllJobPostings() {
        List<JobPosting> jobPostings = jobPostingService.getAllJobPostings();
        return ResponseEntity.ok(jobPostings);
    }

    // Update a job posting by ID
    @PutMapping("/jobpostingUpdate/{id}")
    public ResponseEntity<JobPosting> updateJobPosting(@PathVariable Long id, @RequestBody JobPosting jobPostingDetails) {
        try {
            JobPosting updatedJobPosting = jobPostingService.updateJobPosting(id, jobPostingDetails);
            return ResponseEntity.ok(updatedJobPosting);
        } catch (JobPostingNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    
    // Delete a job posting by ID
    @DeleteMapping("/jobpostingDelete/{id}")
    public ResponseEntity<String> deleteJobPosting(@PathVariable Long id) {
        try {
            boolean isDeleted = jobPostingService.deleteJobPosting(id);
            if (isDeleted) {
                return ResponseEntity.ok("Job posting deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to delete the job posting.");
            }
        } catch (JobPostingNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Job posting not found.");
        }
    }
    
    
    // Endpoint to get job postings sorted by salary in ascending order
    @GetMapping("JobPostingSorted/asc")
    public List<JobPosting> getJobPostingsSortedBySalaryAsc() {
        return jobPostingService.getJobPostingsSortedBySalaryAsc();
    }

    // Endpoint to get job postings sorted by salary in descending order
    //http://localhost:8080/JobPostingSorted/desc
    @GetMapping("/JobPostingSorted/desc")
    public List<JobPosting> getJobPostingsSortedBySalaryDesc() {
        return jobPostingService.getJobPostingsSortedBySalaryDesc();
    }
}
