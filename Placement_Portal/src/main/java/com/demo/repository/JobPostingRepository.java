package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.JobPosting;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
	 // Custom query to search job postings by name
    List<JobPosting> findByJobNameContainingIgnoreCase(String jobName);
    
 // Method to fetch all job postings sorted by salary
    List<JobPosting> findAllByOrderByJobSalaryAsc(); // For ascending order

    // Or for descending order
    List<JobPosting> findAllByOrderByJobSalaryDesc(); // For descending order
   }