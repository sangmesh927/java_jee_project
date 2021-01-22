package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.DonationCamp;
import com.example.demo.repos.DonationCampRepository;

@Service
public class DonationCampServices {

	@Autowired
	private DonationCampRepository repo;
	
	public List<DonationCamp> findAllCamps(){
		return this.repo.findAll();
	}
	
	public List<DonationCamp> findByArea(String area){
		return this.repo.findByCampLocation(area);
	}
	
	public List<DonationCamp> findRegistration(int id){
		return this.repo.findCampsRegistrationForDonor(id);
	}
}
