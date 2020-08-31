package com.springboot.app.dto;

import java.util.Dictionary;

public class JobSubmitterResponse {
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public Dictionary<String, Object> getMessage() {
		return message;
	}
	public void setMessage(Dictionary<String, Object> message) {
		this.message = message;
	}
	private String success;
	private Dictionary<String,Object> message;
}
