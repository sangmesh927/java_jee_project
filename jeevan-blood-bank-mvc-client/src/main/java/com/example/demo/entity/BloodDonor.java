package com.example.demo.entity;

import java.time.LocalDate;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodDonor {

	private int donorId;
	private String name;
	private int age;
	private int mobileNumber;
	private String gender;
	private String bloodGroup;
	private String email;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfBirth;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfDonation;
	private String address;
	
}
