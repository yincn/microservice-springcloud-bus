package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Result;

@RefreshScope
@RequestMapping("/dept")
@RestController
public class DeptController {
	
	@Value("${config.name:''}")
	private String userName;
	
	private Logger log = LoggerFactory.getLogger(DeptController.class);
	
	@RequestMapping("/get/{id}")
	public Result get(@PathVariable("id") Integer id) {
		log.info("Receive param id:" + id);
		Result result = new Result();
		result.setInfo(userName);
		return result;
	}
}
