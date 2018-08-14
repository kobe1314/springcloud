package com.hsbc.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EurekaContoller {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EurekaContoller.class);
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(value="sayHi")
	private String sayHi(@RequestParam String name) {
		
		System.out.println(request.toString());
		System.out.println(request.getAttribute(name));
		return "你好:" + name;
	}
	
	@GetMapping(value="hi")
	private String callHome() {
		LOGGER.debug("call home");
		return restTemplate.getForObject("http://localhost:8988/miya", String.class);
	}
	
	@GetMapping("/info")
    public String info(){
		LOGGER.debug("call service info");
        return "i'm service-hi";

    }

}
