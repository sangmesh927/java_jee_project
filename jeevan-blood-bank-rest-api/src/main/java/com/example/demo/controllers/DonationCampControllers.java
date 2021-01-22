package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DonationCamp;
import com.example.demo.services.DonationCampServices;

@RestController
@RequestMapping(path = "/api/v2/")
@CrossOrigin(origins = "*")
public class DonationCampControllers {

	@Autowired
	private DonationCampServices service;
	
	// To find all the camps available
	@GetMapping(path = "camps")
	public List<DonationCamp> findAllCamps() throws Exception{
		List<DonationCamp> list = this.service.findAllCamps();
		if(list.isEmpty()) {
			throw new Exception();
		} else {
			return list;
		} 
	}
	
	// To find camps using area
	@GetMapping(path = "camps/{area}")
	public List<DonationCamp> findCampUsingArea(@PathVariable("area") String area) throws Exception{
		List<DonationCamp> list = this.service.findByArea(area);
		if(list.isEmpty()) {
			throw new Exception();
		} else {
			return list;
		}  
	}
	
	// To find camp registration using donor id
	@GetMapping(path = "camps/registration/{id}")
	public List<DonationCamp> findCampRegistrationUsingDonorId(@PathVariable("id") int id) throws Exception{
		List<DonationCamp> list = this.service.findRegistration(id);
		if(list.isEmpty()) {
			System.out.println("no camps");
			throw new Exception();
		} else {
			return list;
		} 
	}
}
