 package com.springboot.app.service;

import org.springframework.stereotype.Service;

import com.springboot.app.dto.DeviceResponse;

@Service
public class ScheduleServiceImpl implements IScheduleService{

	@Override
	public DeviceResponse getSchedulers() {
		DeviceResponse response = new DeviceResponse();
		response.setName("FCFS");
		response.setDesc("This is the default scheduling policy used by dewsim_server which assigns jobs to nodes in the order they are submitted");
		return response;
	}

}
