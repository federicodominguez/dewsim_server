package com.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springboot.app.dto.JobSubmitterResponse;
import com.springboot.app.service.IJobService;
import com.springboot.app.util.Response;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
public class JobController {
	
	
	@GetMapping("/job/{submitter}")
	public ResponseEntity<?>getJobsProgress(@PathVariable String submitter){
		return new ResponseEntity<JobSubmitterResponse>(jobService.findAll(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/job/{submitter}", method = RequestMethod.POST, produces = "application/json;", consumes = {"multipart/form-data"})
	public @ResponseBody ResponseEntity<String> readJson(@PathVariable String submitter,
														 @RequestParam("newJobFile") MultipartFile newJobFile) {
		Response response = this.jobService.readJson(submitter, newJobFile);
		return ResponseEntity.status(response.getCode())
				.contentType(MediaType.APPLICATION_JSON)
				.body(this.gson.toJson(response));
	}
	
	@Autowired
	private IJobService jobService;
	
    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .create();
}