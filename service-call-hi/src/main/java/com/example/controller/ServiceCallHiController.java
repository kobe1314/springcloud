package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServiceCallHiController {

	private static final Logger LOGGGER = LoggerFactory.getLogger(ServiceCallHiController.class);
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(value="hi")
	public String sayHi() {
		LOGGGER.debug("this is hi service");
		return "hi";
	}
	@GetMapping(value="miya")
	public String callHiService() {
		return restTemplate.getForObject("http://localhost:8763/info", String.class);
	}
}
