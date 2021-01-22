package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DonationCampList {

	private List<DonationCamp> campList;

	public DonationCampList() {
		this.campList = new ArrayList<>();
	}

}
