package com.springboot.app.dto;

import java.util.List;

public class ResponseList {
	
	public List<DeviceResponse> getReslist() {
		return reslist;
	}

	public void setReslist(List<DeviceResponse> reslist) {
		this.reslist = reslist;
	}
	
	List<DeviceResponse> reslist;
}
