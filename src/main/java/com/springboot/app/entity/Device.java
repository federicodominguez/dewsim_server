package com.springboot.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="devices")
public class Device implements Serializable{
	
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
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getBattery_level() {
		return battery_level;
	}
	public void setBattery_level(int battery_level) {
		this.battery_level = battery_level;
	}
	public String getBattery_status() {
		return battery_status;
	}
	public void setBattery_status(String battery_status) {
		this.battery_status = battery_status;
	}
	
	public List<String> getDev_front() {
		return dev_front;
	}
	public void setDev_front(List<String> dev_front) {
		this.dev_front = dev_front;
	}

	@Id
	private String name;
	
	private String desc;
	private String model;
	private String ip;
	private int battery_level;
	private String battery_status;
	
	@ElementCollection
	private List<String> dev_front;

	private static final long serialVersionUID = 1L;

}
