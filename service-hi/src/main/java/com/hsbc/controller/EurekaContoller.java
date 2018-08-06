package com.hsbc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaContoller {

	@Autowired
	private HttpServletRequest request;
	
	@GetMapping(value="sayHi")
	private String sayHi(@RequestParam String name) {
		
		System.out.println(request.toString());
		System.out.println(request.getAttribute(name));
		return "你好:" + name;
	}
}
