package com.example.demo.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repos.BloodDonorRepository;
import com.example.demo.entity.BloodDonor;
import com.example.demo.entity.DonationCamp;

@Service
public class BloodDonorService {

	@Autowired 
	private BloodDonorRepository repo;
	
	public List<BloodDonor> findAll(){
		return this.repo.findAll();
	}
	
	public BloodDonor saveDonor(BloodDonor donor) {
		return this.repo.save(donor);
	}
	
	public BloodDonor findByDonorId(int id) {
		return this.repo.findByDonorId(id); 
	}
	
	public List<BloodDonor> findByBloodGroup(String group) {
		return this.repo.findByBloodGroup(group); 
	}
	
	public List<BloodDonor> findEligibleDonor() {
		return this.repo.findEligibleDonors(); 
	}
	
	public List<BloodDonor> findEligibleDonorsByGroup(String group) {
		return this.repo.findEligibleDonorsByGroup(group);
	}
	
	public List<BloodDonor> findDonorByLocation(String address) {
		return this.repo.findByAddress(address);
	}
	
	public int updateDonor(int id,BloodDonor donor) {
		String name = donor.getName();
		int age = donor.getAge();
		int mobileNumber = donor.getMobileNumber();
		String gender = donor.getGender();
		String bloodGroup = donor.getBloodGroup();
		String email = donor.getEmail();
		LocalDate dateOfBirth = donor.getDateOfBirth();
		LocalDate dateOfDonation = donor.getDateOfDonation();
		String address = donor.getAddress();
		
		int rowsUpdated = this.repo.updateDonor(name,age,mobileNumber,gender,
				bloodGroup,email,Date.valueOf(dateOfBirth),Date.valueOf(dateOfDonation),
				address,id);
		return rowsUpdated;
	}
	
	public boolean remove(int id) {
		boolean deleted = false;
		
		if(this.repo.existsById(id)) {
			this.repo.deleteById(id);
			deleted = true;
		}
		return deleted;
	}
}
