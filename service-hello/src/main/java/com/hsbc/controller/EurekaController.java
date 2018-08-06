package com.hsbc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaController {
	@Value("${server.port}")
	private String port;
	
	@GetMapping(value="sayHello")
	private String sayHello(@RequestParam String name) {
		
		return "Hello :" +name + "your sever port is :" + port;
	}
}
