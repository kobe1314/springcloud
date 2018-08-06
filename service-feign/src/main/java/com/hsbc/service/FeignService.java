package com.hsbc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="service-hello",fallback=FeignServiceImpl.class)
public interface FeignService {
	@GetMapping(value="sayHello")
	public String sayHelloFromOneClient(@RequestParam(value="name") String name);
}
