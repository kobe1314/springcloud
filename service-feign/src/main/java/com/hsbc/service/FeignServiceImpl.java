package com.hsbc.service;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceImpl implements FeignService {

	@Override
	public String sayHelloFromOneClient(String name) {
		return name + ",Feign way return api error";
	}

}
