package com.springboot.app.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.app.exception.FileNotFound;
import com.springboot.app.dto.DeviceAllResponse;
import com.springboot.app.dto.DeviceResponse;
import com.springboot.app.dto.ResponseList;
import com.springboot.app.entity.Device;
import com.springboot.app.repository.IDeviceRepository;
import com.springboot.app.util.FileStorageProperties;
import com.springboot.app.util.Response;

@Service
public class DeviceServiceImpl implements IDeviceService {
	
	@Autowired
	public DeviceServiceImpl(IDeviceRepository deviceRepository, FileStorageProperties properties) {
		this.deviceRepository = deviceRepository;
		this.rootLocation = Paths.get(properties.getLocation()).normalize();
	      if (Files.notExists(this.rootLocation)) {
	            try {
	                Files.createDirectory(this.rootLocation);
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	}

	@Override
	@Transactional(readOnly = true)
	public DeviceAllResponse findAll() {
		List<Device> devices = (List<Device>) deviceRepository.findAll();
		List<DeviceResponse> reslist = new ArrayList<DeviceResponse>();
		for(Device d : devices) {
			DeviceResponse res = new DeviceResponse();
			mapper(d,res);
			reslist.add(res);
		}
		ResponseList res = new ResponseList();
		res.setReslist(reslist);
		DeviceAllResponse response = new DeviceAllResponse();
		response.setSuccess("true");
		response.setInfo(res.getReslist());
		return response;
	}
	
	private void mapper(Device d, DeviceResponse res) {
		List<String> attrNames = new ArrayList<String>();
		List<String> attrTypes = new ArrayList<String>();
		List<Object> attrValues = new ArrayList<Object>();
		
		attrNames.add("model");
		attrNames.add("battery_status");
		attrTypes.add("string");
		attrTypes.add("string");
		attrValues.add(d.getModel());
		attrValues.add(d.getBattery_status());
		
		if(d.getDev_front() != null && !d.getDev_front().isEmpty()) {
			attrNames.add("dev_front");
			attrTypes.add("string");
			attrValues.add(d.getDev_front());
		}
		
		res.setName(d.getName());
		res.setDesc(d.getDesc());
		res.setIp(d.getIp());
		res.setBattery_level(d.getBattery_level());
		res.setAttrNames(attrNames);
		res.setAttrTypes(attrTypes);
		res.setAttrValues(attrValues);
	}
	
	@Override
	public Response addImage(String name, MultipartFile image) {
		
		String path;
		Device device = this.deviceRepository.getByName(name);
        try {
            path = saveImage(image);
            if(path != null) {
                List<String> images = device.getDev_front();
                images.add(path);
                device.setDev_front(images);
                this.deviceRepository.save(device);
                return new Response(null, device, HttpStatus.CREATED);
            }
        } catch (FileNotFound e) {
            return new Response("Error saving image", null, HttpStatus.BAD_REQUEST);
        }
        // return response
        return new Response("Error saving todo.", null, HttpStatus.BAD_REQUEST);
    }
	
	public String saveImage(MultipartFile image) {
        // Normalize file name
        String fileName = UUID.randomUUID().toString() + ".png";
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                return null;
            }
            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.rootLocation.resolve(fileName);
            Files.copy(image.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return this.rootLocation.toString() + "/" + fileName;
        } catch (IOException ex) {
            try {
                throw new FileNotFound("Error saving image.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
	
	private IDeviceRepository deviceRepository;
	private final Path rootLocation;

}
