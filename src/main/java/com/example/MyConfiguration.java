package com.example;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class MyConfiguration {
		
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	     RestTemplate restTemplate = builder.build();
	     return restTemplate;
	}
}
