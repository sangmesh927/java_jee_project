package com.example.demo.controllers;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.BloodDonor;
import com.example.demo.entity.DonationCamp;
import com.example.demo.entity.DonationCampRegistration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Controller
public class ClientController {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	public ModelAndView modelView;
	
	@Autowired
	public BloodDonor donor;
	
	// To get the form to add donor to database
	@GetMapping(path = "/donor")
	@HystrixCommand(fallbackMethod = "simpleFallbackMethod")
	public ModelAndView init() {
		modelView.setViewName("addDonor");
		modelView.addObject("command", donor);
		System.out.println("in view");
		
		return modelView;
	}
	
	// To get update donor form
	@GetMapping(path = "/newdonor")
	@HystrixCommand(fallbackMethod = "simpleFallbackMethod")
	public ModelAndView updateDonor() {
		modelView.setViewName("updateDonor");
		modelView.addObject("message1", null);
		return modelView;
	}
	
	// To get delete donor form
	@GetMapping(path = "/deleteDonorForm")
	@HystrixCommand(fallbackMethod = "simpleFallbackMethod")
	public ModelAndView showDeleteDonorForm() {
		modelView.setViewName("removeDonor");
		modelView.addObject("message2", null);
		return modelView;
	}
	
	// Shows registrations for the camp using donorId
	@GetMapping(path = "/showRegistrationForCamp")
	@HystrixCommand(fallbackMethod = "simpleFallbackMethod")
	public ModelAndView showRegistrations() {
		modelView.setViewName("showRegistrationForCamp");
		return modelView;
	}
	
	// shows all registered donors
	@GetMapping(path = "/viewDonors")
	@HystrixCommand(fallbackMethod = "simpleFallbackMethod")
	public ModelAndView showAllDonors() {
		String url = "http://localhost:4040/api/v1/donors";
		ResponseEntity<BloodDonor[]> response = this.template.getForEntity(url, BloodDonor[].class);
		BloodDonor[] donors = response.getBody();
		modelView.setViewName("showAllDonors");
		modelView.addObject("donorsList",Arrays.asList(donors));
		return modelView;
	}
	
	// used to get form to enter area to show donors by area
	@GetMapping(path = "/donorByAreaForm")
	@HystrixCommand(fallbackMethod = "simpleFallbackMethod")
	public ModelAndView showDonorsByAreaForm() {
		modelView.setViewName("showDonorsByArea");
		modelView.addObject("donorsList1", null);
		return modelView;
	}
	
	// it shows donors by area
	@GetMapping(path = "/donorByArea")
	@HystrixCommand(fallbackMethod = "showDonorsByAreaFallback")
	public ModelAndView showDonorsByArea(@RequestParam("area") String area) {
		String url = "http://localhost:4040/api/v1/donors/location/"+area;
		ResponseEntity<BloodDonor[]> response = this.template.getForEntity(url, BloodDonor[].class);
		BloodDonor[] donors = response.getBody();
		modelView.setViewName("showDonorsByArea");
		modelView.addObject("donorsList1", Arrays.asList(donors));
		return modelView;
	}
	
	// Fallback method for the function "showDonorsByArea" 
	public ModelAndView showDonorsByAreaFallback(String area) {
		modelView.setViewName("simpleFallBackPage");
		modelView.addObject("fallMessage", "Cannot find resources of type :" + area);
		return modelView;
	}
	
	// used to get form to enter group to show donors by group
	@GetMapping(path = "/donorByGroupForm")
	@HystrixCommand(fallbackMethod = "simpleFallbackMethod")
	public ModelAndView showDonorsByGroupForm() {
		modelView.setViewName("showDonorsByGroup");
		modelView.addObject("donorsList1", null);
		return modelView;
	}
	
	// it shows donors by group
	@GetMapping(path = "/donorByGroup")
	@HystrixCommand(fallbackMethod = "showDonorsByGroupFallback")
	public ModelAndView showDonorsByGroup(@RequestParam("group") String group) {
		String url = "http://localhost:4040/api/v1/donors/group/"+group;
		ResponseEntity<BloodDonor[]> response = this.template.getForEntity(url, BloodDonor[].class);
		BloodDonor[] donors = response.getBody();
		modelView.setViewName("showDonorsByGroup");
		modelView.addObject("donorsList1", Arrays.asList(donors));
		return modelView;
	}
	
	// it is used to get form to enter group to show eligible donors by group
	@GetMapping(path = "/eligibleDonorByGroupForm")
	@HystrixCommand(fallbackMethod = "simpleFallbackMethod")
	public ModelAndView showEligibleDonorsByGroupForm() {
		modelView.setViewName("showEligibleDonorsByGroup");
		modelView.addObject("donorsList2", null);
		return modelView;
	}
	
	// it shows eligible donors by group
	@GetMapping(path = "/eligibleDonorByGroup")
	@HystrixCommand(fallbackMethod = "showDonorsByGroupFallback")
	public ModelAndView showEligibleDonorsByGroup(@RequestParam("group") String group) {
		String url = "http://localhost:4040/api/v1/donors/blooddonor/"+group;
		ResponseEntity<BloodDonor[]> response = this.template.getForEntity(url, BloodDonor[].class);
		BloodDonor[] donors = response.getBody();
		modelView.setViewName("showEligibleDonorsByGroup");
		modelView.addObject("donorsList2", Arrays.asList(donors));
		return modelView;
	}
	
	// Fallback method for the function "showEligibleDonorsByGroup"
	public ModelAndView showDonorsByGroupFallback(String group) {
		modelView.setViewName("simpleFallBackPage");
		modelView.addObject("fallMessage", "Cannot find resources of type :" + group);
		return modelView;
	}
	
	// shows all eligible donors
	@GetMapping(path = "/eligibleDonors")
	@HystrixCommand(fallbackMethod = "simpleFallbackMethod")
	public ModelAndView showEligibleDonors() {
		String url = "http://localhost:4040/api/v1/donors/blooddonor";
		ResponseEntity<BloodDonor[]> response = this.template.getForEntity(url, BloodDonor[].class);
		BloodDonor[] donors = response.getBody();
		modelView.setViewName("showEligibleDonors");
		modelView.addObject("donorsList1", Arrays.asList(donors));
		return modelView;
	}
	
	// shows all donation camps
	@GetMapping(path = "/showCamps")
	@HystrixCommand(fallbackMethod = "simpleFallbackMethod")
	public ModelAndView showDonationCamps() {
		String url = "http://localhost:4040/api/v2/camps";
		ResponseEntity<DonationCamp[]> response = this.template.getForEntity(url,DonationCamp[].class);
		DonationCamp[] camps = response.getBody();
		System.out.println("list :" + Arrays.asList(camps));
		modelView.setViewName("showDonationCamps");
		modelView.addObject("list", Arrays.asList(camps));
		return modelView;
	}
	
	// shows registrations for camps
	@GetMapping(path = "/showRegistrations")
	@HystrixCommand(fallbackMethod = "showRegistrationsForCampsFallback")
	public ModelAndView showRegistrationsForCamps(@RequestParam("donorId") int donorId) {
		String url = "http://localhost:4040/api/v2/camps/registration/"+donorId;
		ResponseEntity<DonationCamp[]> response = this.template.getForEntity(url,DonationCamp[].class);
		DonationCamp[] registrations = response.getBody();
		modelView.setViewName("showRegistrationForCamp");
		modelView.addObject("registrationList", Arrays.asList(registrations));
		return modelView;
	}
	
	// Fallback method for the function "showRegistrationsForCamps"
	public ModelAndView showRegistrationsForCampsFallback(int donorId) {
		modelView.setViewName("simpleFallBackPage");
		modelView.addObject("fallMessage", "Cannot find resources with id :" + donorId);
		return modelView;
	}
	
	// It will register the donor for a donation camp
	@PostMapping(path = "/register")
	@HystrixCommand(fallbackMethod = "registerMeFallback")
	public ModelAndView registerMe(@RequestParam("donorId") int donorId,
									@RequestParam("campId") int campId) { 
		DonationCampRegistration registration = new DonationCampRegistration(donorId,campId);
		this.template.postForObject("http://localhost:4040/api/v3/donorCamp/", registration, DonationCampRegistration.class);
		modelView = showDonationCamps();
		return modelView;
	}
	
	// Fallback method for the function "registerMe"
	public ModelAndView registerMeFallback(int donorId,int campId) {
		modelView.setViewName("simpleFallBackPage");
		modelView.addObject("fallMessage", "Cannot register donor with id : " + donorId + " for campId : " + campId);
		return modelView;
	}
	
	// It adds the donor to the database
	@PostMapping(path = "/donor")
	@HystrixCommand(fallbackMethod = "addDonorFallback")
	public ModelAndView addDonor(@ModelAttribute("command") BloodDonor donor) {
		
		BloodDonor added = this.template.postForObject("http://localhost:4040/api/v1/donors/", donor, BloodDonor.class);
		modelView.setViewName("addDonor");
		String message = "Donor Not added";
		if(added != null) {
			message = "Donor Added Successfully : Id is = ";
			message += added.getDonorId();
			modelView.addObject("message", message);
		}
		
		return modelView;
	}
	
	// fallback method for the function "addDonor"
	public ModelAndView addDonorFallback(BloodDonor donor) {
		modelView.setViewName("simpleFallBackPage");
		modelView.addObject("fallMessage", "Cannot Register donor");
		return modelView;
	}
	
	// It will get user data from database using donorId so that donor can update it
	@PostMapping(path = "/thisdonor")
	@HystrixCommand(fallbackMethod = "getUserDataFallback")
	public ModelAndView getUserData(@RequestParam("id") int id) {
		String url = "http://localhost:4040/api/v1/donors/" + id;
		BloodDonor donor = this.template.getForObject(url, BloodDonor.class);
		System.out.println("id is" + id);
		System.out.println("fileds are :" + donor);
		modelView.setViewName("updateDonorForm");
		modelView.addObject("command", donor);
		
		return modelView;
	}
	
	// Fallback method for the function "getUserData"
	public ModelAndView getUserDataFallback(int id) {
		System.out.println("calling fallback");
		modelView.setViewName("simpleFallBackPage");
		modelView.addObject("fallMessage", "Cannot get donor with id : " + id);
		return modelView;
	}
	
	// it updates the data in the database
	@PostMapping(path = "/blooddonor")
	@HystrixCommand(fallbackMethod = "updateUserDataFallback")
	public ModelAndView updateUserData(@ModelAttribute("command") BloodDonor donor) {
		int id = donor.getDonorId();
		System.out.println("id is :" + id);
		System.out.println("donor in mvc :" + donor);
		String url = "http://localhost:4040/api/v1/donors/"+id;

		this.template.put(url,donor);;
		modelView.setViewName("updateDonor");
		modelView.addObject("message1", "Donor updated successfully");
		
		return modelView;
	}
	
	// Fallback method for the function "updateUserData"
	public ModelAndView updateUserDataFallback(BloodDonor donor) {
		modelView.setViewName("simpleFallBackPage");
		modelView.addObject("fallMessage", "Cannot update donor");
		return modelView;
	}
	
	// It removes the donor form the database
	@PostMapping(path = "/deleteDonor")
	@HystrixCommand(fallbackMethod = "deleteDonorFallback")
	public ModelAndView deleteDonor(@RequestParam("id") int id) {
		String url = "http://localhost:4040/api/v1/donors/"+id;
			this.template.delete(url);
			modelView.setViewName("removeDonor");
			modelView.addObject("message2", "Donor Deleted Successfully");
		return modelView;
	}
	
	// Fallback method for the function "deleteDonor"
	public ModelAndView deleteDonorFallback(int id) {
		modelView.setViewName("simpleFallBackPage");
		modelView.addObject("fallMessage", "Could not delete donor with id : " + id);
		return modelView;
	}
	
	// Fallback method for the remaining functions
	public ModelAndView simpleFallbackMethod() {
		modelView.setViewName("simpleFallBackPage");
		modelView.addObject("fallMessage", "Could not process your Request");
		return modelView;
	}
	
}
