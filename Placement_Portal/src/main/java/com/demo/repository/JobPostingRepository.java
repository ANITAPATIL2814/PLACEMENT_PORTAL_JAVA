package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.JobPosting;

public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {

}