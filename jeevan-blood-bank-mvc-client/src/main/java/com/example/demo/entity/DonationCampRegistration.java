package com.example.demo.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;


@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DonationCampRegistration {

	int regId;
	int donorId;
	int campId;
	
	public DonationCampRegistration(int donorId, int campId) {
		super();
		this.donorId = donorId;
		this.campId = campId;
	}
	
	
}
