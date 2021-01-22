package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DonationCampRegistration;
import com.example.demo.repos.DonationCampRegistrationRepository;

@Service
public class DonationCampRegistrationServices {

	@Autowired
	private DonationCampRegistrationRepository repo;
	
	public DonationCampRegistration registerDonor(DonationCampRegistration registration) {
		return this.repo.save(registration);
	}
	
}
