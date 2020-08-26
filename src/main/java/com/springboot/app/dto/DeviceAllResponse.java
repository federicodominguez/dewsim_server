package com.springboot.app.dto;

import java.util.List;

public class DeviceAllResponse {
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public List<DeviceResponse> getInfo() {
		return info;
	}
	public void setInfo(List<DeviceResponse> info) {
		this.info = info;
	}
	
	private String success;
	private List<DeviceResponse> info;

}
