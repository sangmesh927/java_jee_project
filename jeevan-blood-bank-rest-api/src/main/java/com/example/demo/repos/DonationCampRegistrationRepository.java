package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.DonationCampRegistration;

@Repository
public interface DonationCampRegistrationRepository extends JpaRepository<DonationCampRegistration, Integer> {

}
