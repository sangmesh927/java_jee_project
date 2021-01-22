package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.BloodDonor;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
public class JeevanBloodBankMvcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(JeevanBloodBankMvcClientApplication.class, args);
	}
	
	@Bean
	public RestTemplate template() {
		return new RestTemplate();
	}
	
	@Bean
	public ModelAndView modelView() {
		return new ModelAndView();
	}
	
	@Bean
	public BloodDonor donor() {
		return new BloodDonor();
	}

}
