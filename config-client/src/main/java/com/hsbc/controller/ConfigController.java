package com.hsbc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
	
	@Value("${foo}")
	private String foo;
	
	@GetMapping(value="fetchServerInfo")
	public String getServerConfigInfo() {
		return "server config info is :" + foo;
	}
	
	public String getFoo() {
		return foo;
	}
	
	public void setFoo(String foo) {
		this.foo = foo;
	}
}
