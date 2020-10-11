package com.springboot.app.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.app.dto.JobSubmitterResponse;
import com.springboot.app.dto.ResponseJobs;
import com.springboot.app.entity.Device;
import com.springboot.app.entity.Job;
import com.springboot.app.repository.IDeviceRepository;
import com.springboot.app.repository.IJobRepository;
import com.springboot.app.util.Response;

@Service
public class JobServiceImpl implements IJobService{
	

	@Override
	public Response readJson(String submitter, MultipartFile file) {
		BufferedReader br;
		List<String> result = new ArrayList<>();
		try {

		     String line;
		     InputStream is = file.getInputStream();
		     br = new BufferedReader(new InputStreamReader(is));
		     while ((line = br.readLine()) != null) {
		          result.add(line);
		     }

		  } catch (IOException e) {
		    System.err.println(e.getMessage());       
		  }
		
		List<String> jobs = new ArrayList<>();
		for(String r: result) {
			if(!r.isEmpty()) {
				jobs.add(r);
			}
		}
		
		return new Response(null, jobs, HttpStatus.CREATED);
	}
	
	@Override
	public JobSubmitterResponse findAll() {
		List<Job> jobList = (List<Job>) jobRepository.findAll();
		List<Job> queued = new ArrayList<Job>();
		List<Job> running = new ArrayList<Job>();;
		List<Job> finished = new ArrayList<Job>();
		for(Job job : jobList) {
			if(job.getExecution_status().equals("queued")) {
				queued.add(job);
			} else {
				if(job.getExecution_status().equals("running")) {
					running.add(job);
				} else {
					finished.add(job);
				}
			}
		}
		
		JobSubmitterResponse res = new JobSubmitterResponse();
		ResponseJobs resJobs = new ResponseJobs();
		Dictionary<String, Object> d = new Hashtable<String, Object>();
		List<Device> devices = deviceRepository.findAll();
		for(Device device: devices) {

			resJobs.setQueued(queued);
			resJobs.setRunning(running);
			resJobs.setFinished(finished);
			d.put(device.getName(), resJobs);			
			
		} 
		
		res.setSuccess("true");
		res.setMessage(d);

		return res;
	}
	

	@Override
	public Job addJob(Job job) {
		return jobRepository.save(job);
	}
	
	@Autowired
	public JobServiceImpl (IJobRepository jobRepository, IDeviceRepository deviceRepository) {
		this.jobRepository = jobRepository;
		this.deviceRepository = deviceRepository;
		
	}
	
	private IJobRepository jobRepository;
	private IDeviceRepository deviceRepository;

	
}
