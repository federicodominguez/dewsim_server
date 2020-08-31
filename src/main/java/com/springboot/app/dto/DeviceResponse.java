package com.springboot.app.dto;

import java.util.List;

public class DeviceResponse {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<String> getAttrNames() {
		return attrNames;
	}
	public void setAttrNames(List<String> attrNames) {
		this.attrNames = attrNames;
	}
	public List<String> getAttrTypes() {
		return attrTypes;
	}
	public void setAttrTypes(List<String> attrTypes) {
		this.attrTypes = attrTypes;
	}
	public List<Object> getAttrValues() {
		return attrValues;
	}
	public void setAttrValues(List<Object> attrValues) {
		this.attrValues = attrValues;
	}
	
	public int getBattery_level() {
		return battery_level;
	}
	public void setBattery_level(int battery_level) {
		this.battery_level = battery_level;
	}

	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}

	private String name;
	private String desc;
	private String ip;
	private int battery_level;
	private List<String> attrNames;
	private List<String> attrTypes;
	private List<Object> attrValues;
	
}
