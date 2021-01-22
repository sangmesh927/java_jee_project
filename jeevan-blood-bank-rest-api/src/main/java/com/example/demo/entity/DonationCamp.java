package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "donation_camp")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE) 
public class DonationCamp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int campId;
	String campName;
	String campLocation;
	LocalDate campDate;
	LocalTime campStartTime;
	LocalTime campEndTime;
	
}
