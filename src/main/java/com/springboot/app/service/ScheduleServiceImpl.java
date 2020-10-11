 package com.springboot.app.service;

import org.springframework.stereotype.Service;

import com.springboot.app.dto.ScheduleResponse;

@Service
public class ScheduleServiceImpl implements IScheduleService{

	@Override
	public ScheduleResponse getSchedulers() {
		ScheduleResponse response = new ScheduleResponse();
		response.setName("FCFS");
		response.setDesc("This is the default scheduling policy used by dewsim_server which assigns jobs to nodes in the order they are submitted");
		return response;
	}

}
