package com.springboot.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.entity.Job;


public interface IJobRepository extends CrudRepository<Job, String>{

}
