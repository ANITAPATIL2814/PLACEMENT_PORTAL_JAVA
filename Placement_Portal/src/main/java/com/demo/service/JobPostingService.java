package com.demo.service;

import com.demo.entity.JobPosting;
import com.demo.exception.JobPostingNotFoundException;

import java.util.List;

public interface JobPostingService {

    // Add a new job posting
    JobPosting addJobPosting(JobPosting jobPosting);

    // Retrieve a job posting by ID
    JobPosting getJobPostingById(Long id) throws JobPostingNotFoundException;

   
    
    // Retrieve all job postings
    List<JobPosting> getAllJobPostings();

    // Update an existing job posting
    JobPosting updateJobPosting(Long id, JobPosting jobPostingDetails) throws JobPostingNotFoundException;

    // Delete a job posting by ID
    boolean deleteJobPosting(Long id) throws JobPostingNotFoundException;

	List<JobPosting> searchJobPostingByName(String jobName);
    
	List<JobPosting> getJobPostingsSortedBySalaryAsc();
    
    List<JobPosting> getJobPostingsSortedBySalaryDesc();
}
