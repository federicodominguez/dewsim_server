package com.springboot.app.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jobs")
public class Job implements Serializable {
	
	public Job () {}

	public Job(String job_id, String task_id, String submission_time, String execution_start, String execution_finished,
			String execution_status) {
		this.job_id = job_id;
		this.task_id = task_id;
		this.submission_time = submission_time;
		this.execution_start = execution_start;
		this.execution_finished = execution_finished;
		this.execution_status = execution_status;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public String getTask_id() {
		return task_id;
	}

	public void setTask_id(String task_id) {
		this.task_id = task_id;
	}

	public String getSubmission_time() {
		return submission_time;
	}

	public void setSubmission_time(String submission_time) {
		this.submission_time = submission_time;
	}

	public String getExecution_start() {
		return execution_start;
	}

	public void setExecution_start(String execution_start) {
		this.execution_start = execution_start;
	}

	public String getExecution_finished() {
		return execution_finished;
	}

	public void setExecution_finished(String execution_finished) {
		this.execution_finished = execution_finished;
	}

	public String getExecution_status() {
		return execution_status;
	}

	public void setExecution_status(String execution_status) {
		this.execution_status = execution_status;
	}
	
	@Id
	private String job_id;
	
	private String task_id;
	private String submission_time;
	private String execution_start;
	private String execution_finished;
	private String execution_status;

	private static final long serialVersionUID = 1L;
}
