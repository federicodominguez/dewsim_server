package com.springboot.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.app.dto.JobSubmitterResponse;
import com.springboot.app.entity.Job;
import com.springboot.app.util.Response;

public interface IJobService {
	
	public JobSubmitterResponse findAll();

	public Response readJson(String submitter, MultipartFile file);
	
	public Job addJob(Job job);


}
