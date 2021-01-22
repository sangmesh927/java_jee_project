package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DonationCampRegistration;
import com.example.demo.services.DonationCampRegistrationServices;

@RestController
@RequestMapping(path = "/api/v3/")
public class DonationCampRegistrationControllers {

	@Autowired
	private DonationCampRegistrationServices service; 
	
	// To register donor for a donation camp
	@PostMapping(path = "donorCamp")
	public DonationCampRegistration registerDonor(@RequestBody DonationCampRegistration registration) throws Exception {
		DonationCampRegistration registrationResponse = this.service.registerDonor(registration);
		if(registrationResponse == null) {
			throw new Exception();
		} else {
			return registrationResponse;
		} 
	}
	
	
}
