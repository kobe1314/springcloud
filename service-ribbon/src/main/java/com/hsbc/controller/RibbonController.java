package com.hsbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.service.HelloServiceImpl;
@RestController
public class RibbonController {
	@Autowired
	HelloServiceImpl helloServiceImpl;
	
	@GetMapping(value="hello")
	private String sayHello(@RequestParam String name) {
		
		return helloServiceImpl.fetchService(name);
	}
}
