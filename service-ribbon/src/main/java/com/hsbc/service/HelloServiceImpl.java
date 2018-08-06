package com.hsbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HelloServiceImpl {
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="error")
	public String fetchService(String name) {
		return restTemplate.getForObject("http://SERVICE-HELLO/sayHello?name="+name, String.class);
	}
	
	public String error(String name) {
		return "hello" + name + "api happen error";
	}
}
