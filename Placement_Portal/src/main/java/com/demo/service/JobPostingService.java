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

   
}
