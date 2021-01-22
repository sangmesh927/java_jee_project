package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entity.BloodDonor;
import com.example.demo.entity.DonationCamp;
import com.example.demo.services.BloodDonorService;

@RestController
@RequestMapping(path = "/api/v1/")
@CrossOrigin(origins = "*")
public class BloodDonorControllers {

	@Autowired
	private BloodDonorService service;
	
	// To find a specific donor using it's id
	@GetMapping(path = "donors/{id}")
	public BloodDonor findByDonorId(@PathVariable("id") int id) throws Exception {
		BloodDonor donor = this.service.findByDonorId(id);
		if(donor == null) {
			throw new Exception();
		} else {
			return donor;
		}
	}
	
	// To find all donors available
	@GetMapping(path = "donors")
	public List<BloodDonor> findDonors() throws Exception{
		List<BloodDonor> list = this.service.findAll();
		if(list.isEmpty()) {
			throw new Exception();
		} else {
			return list;
		}
	}
	
	// To find all eligible donors
	@GetMapping(path = "donors/blooddonor")
	public List<BloodDonor> findEligibleDonor() throws Exception{
		List<BloodDonor> list = this.service.findEligibleDonor();
		if(list.isEmpty()) {
			throw new Exception();
		} else {
			return list;
		}
	}
	
	// To find eligible donors by group
	@GetMapping(path = "/donors/blooddonor/{group}")
	public List<BloodDonor> findEligibleDonorsByGroup(@PathVariable("group") String group) throws Exception{
		List<BloodDonor> list = this.service.findEligibleDonorsByGroup(group);
		if(list.isEmpty()) {
			throw new Exception();
		} else {
			return list;
		}
	}
	
	// To find donors by location
	@GetMapping(path = "donors/location/{location}")
	public List<BloodDonor> findDonorByLocation(@PathVariable("location") String address) throws Exception{
		List<BloodDonor> list = this.service.findDonorByLocation(address);
		if(list.isEmpty()) {
			throw new Exception();
		} else {
			return list;
		}
	}
	
	// To find donors by group
	@GetMapping(path = "donors/group/{group}")
	public List<BloodDonor> findDonorsByGroup(@PathVariable("group") String group) throws Exception{
		List<BloodDonor> list =  this.service.findByBloodGroup(group);
		if(list.isEmpty()) {
			throw new Exception();
		} else {
			return list;
		}
	}
	
	// To save the donor in the database
	@PostMapping(path = "donors")
	public BloodDonor saveDonor(@RequestBody BloodDonor donor) throws Exception {
		BloodDonor responseDonor = this.service.saveDonor(donor);
		if(responseDonor == null) {
			throw new Exception();
		} else {
			return responseDonor;	
		}
	}

	// To update the donor in the database
	@PutMapping(path = "donors/{id}")
	public ResponseEntity<String> updateDonor(@PathVariable("id") int id,@RequestBody BloodDonor donor) throws Exception{

		int rowsUpdated = this.service.updateDonor(id,donor);
		
		if(rowsUpdated > 0) {
			String message = "Information Updated";
			return ResponseEntity.ok().body(message);
		}
		else {
			throw new Exception();
		}
	}
	
	// To delete the donor from the database
	@DeleteMapping(path = "donors/{id}")
	public ResponseEntity<String> deleteDonor(@PathVariable("id") int id) throws Exception{
		String message = null;
		
			boolean deleted = this.service.remove(id);
			if(deleted) {
				message = "Donor Removed Successfully";
				return ResponseEntity.ok().body(message);
			} else {
				System.out.println("Not deleted");
				throw new Exception();
			}
	}
}
