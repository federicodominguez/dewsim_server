package com.springboot.app.service;

import java.util.Dictionary;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.app.util.Response;

public interface IJobService {
	
	public Dictionary<String, Object> findAll();

	public Response readJson(String submitter, MultipartFile file);

}
