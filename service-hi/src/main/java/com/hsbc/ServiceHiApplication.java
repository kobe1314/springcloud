package com.hsbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@SpringBootApplication
//@EnableEurekaClient
public class ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	@Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
