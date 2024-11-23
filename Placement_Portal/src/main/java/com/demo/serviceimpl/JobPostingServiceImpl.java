package com.demo.serviceimpl;

import com.demo.entity.JobPosting;
import com.demo.exception.JobPostingNotFoundException;
import com.demo.repository.JobPostingRepository;
import com.demo.service.JobPostingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingServiceImpl implements JobPostingService {

    @Autowired
    private JobPostingRepository jobPostingRepository;

    @Override
    public JobPosting addJobPosting(JobPosting jobPosting) {
        // Save and return the newly created job posting
        return jobPostingRepository.save(jobPosting);
    }

    @Override
    public JobPosting getJobPostingById(Long id) throws JobPostingNotFoundException {
        // Find job posting by ID or throw an exception if not found
        return jobPostingRepository.findById(id)
                .orElseThrow(() -> new JobPostingNotFoundException("Job Posting not found with ID: " + id));
    }

    @Override
    public List<JobPosting> getAllJobPostings() {
        // Retrieve and return all job postings
        return jobPostingRepository.findAll();
    }

    // Update an existing job posting
    @Override
    public JobPosting updateJobPosting(Long id, JobPosting jobPostingDetails) throws JobPostingNotFoundException {
        // Check if the job posting exists by its ID
        JobPosting existingJobPosting = jobPostingRepository.findById(id)
                .orElseThrow(() -> new JobPostingNotFoundException("Job Posting not found with ID: " + id));

        // Update the job posting fields
        existingJobPosting.setJobTitle(jobPostingDetails.getJobTitle());
        existingJobPosting.setJobDescription(jobPostingDetails.getJobDescription());
        existingJobPosting.setJobLocation(jobPostingDetails.getJobLocation());
        existingJobPosting.setCompany(jobPostingDetails.getCompany());
        existingJobPosting.setJobSalary(jobPostingDetails.getJobSalary());

        // Save and return the updated job posting
        return jobPostingRepository.save(existingJobPosting);
    }

    // Delete a job posting by ID
    @Override
    public boolean deleteJobPosting(Long id) throws JobPostingNotFoundException {
        // Find the job posting by its ID
        JobPosting existingJobPosting = jobPostingRepository.findById(id)
                .orElseThrow(() -> new JobPostingNotFoundException("Job Posting not found with ID: " + id));

        // Delete the job posting from the repository
        jobPostingRepository.delete(existingJobPosting);
        
        // Return true to indicate the job posting was successfully deleted
        return true;
    }
}
