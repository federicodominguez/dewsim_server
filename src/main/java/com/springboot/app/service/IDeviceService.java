package com.springboot.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.app.dto.DeviceAllResponse;
import com.springboot.app.util.Response;

public interface IDeviceService {
	
	public DeviceAllResponse findAll();
	public Response addImage(String name, MultipartFile image);

}
