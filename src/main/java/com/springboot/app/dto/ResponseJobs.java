package com.springboot.app.dto;

import java.util.List;

import com.springboot.app.entity.Job;


public class ResponseJobs {
		
	public List<Job> getQueued() {
		return queued;
	}
	public void setQueued(List<Job> queued) {
		this.queued = queued;
	}
	public List<Job> getRunning() {
		return running;
	}
	public void setRunning(List<Job> running) {
		this.running = running;
	}
	public List<Job> getFinished() {
		return finished;
	}
	public void setFinished(List<Job> finished) {
		this.finished = finished;
	}
	
	private List<Job> queued;
	private List<Job> running;
	private List<Job> finished;
}
