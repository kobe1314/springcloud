package com.hsbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.service.FeignService;

@RestController
public class FeignController {
	
	@Autowired
	FeignService FeignService;
	
	@GetMapping(value="hello")
	public String sayHelloFromFeign(@RequestParam String name) {
		return FeignService.sayHelloFromOneClient(name);
	}
}
