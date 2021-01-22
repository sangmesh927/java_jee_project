package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BloodDonor;
import com.example.demo.entity.DonationCamp;

@Repository
public interface DonationCampRepository extends JpaRepository<DonationCamp, Integer> {

	
	public List<DonationCamp> findByCampLocation(String area);
	
	// get camps for the donor for which he has registered
	@Query(value = "select c.campId,c.campName,c.campLocation,c.campDate,c.campStartTime,"
			+ "c.campEndTime from donation_camp c inner join donation_camp_registration r"
			+ " on c.campId=r.campId where r.donorId=:id",nativeQuery = true)
	public List<DonationCamp> findCampsRegistrationForDonor(@Param("id") int id);
}
