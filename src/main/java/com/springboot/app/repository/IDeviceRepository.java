package com.springboot.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.entity.Device;


public interface IDeviceRepository extends CrudRepository<Device,String>{
	
	Device getByName(String name);
	List<Device> findAll();
}
