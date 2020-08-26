package com.springboot.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.springboot.app.dto.DeviceAllResponse;
import com.springboot.app.service.IDeviceService;
import com.springboot.app.util.Response;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class DeviceController {

	@GetMapping("/devices/all")
	public ResponseEntity<?> getDevices() {
		DeviceAllResponse res = deviceService.findAll();
		return new ResponseEntity<DeviceAllResponse>(res, HttpStatus.OK);
	}

	@RequestMapping(value = "/devices/{name}", method = RequestMethod.PATCH, produces = "application/json;", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody ResponseEntity<String> addImage(@PathVariable String name,
														 @RequestParam("image") MultipartFile image) {
		Response response = this.deviceService.addImage(name, image);
		return ResponseEntity.status(response.getCode())
				.contentType(MediaType.APPLICATION_JSON)
				.body(this.gson.toJson(response));
	}

	@Autowired
	private IDeviceService deviceService;
	
    private Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .serializeNulls()
            .create();

}
