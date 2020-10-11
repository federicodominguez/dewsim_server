package com.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.dto.ScheduleResponse;
import com.springboot.app.service.IScheduleService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
public class ScheduleController {
	
	@GetMapping("/getSchedulers")
	public ResponseEntity<?> getSchedulers() {
		ScheduleResponse response = scheduleService.getSchedulers();
		return new ResponseEntity<ScheduleResponse>(response,HttpStatus.OK);
		
	}
	
	@Autowired
	private IScheduleService scheduleService;
}
