package com.example.demo.repos;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.BloodDonor;
import com.example.demo.entity.DonationCamp;

public interface BloodDonorRepository extends JpaRepository<BloodDonor, Integer> {

	public List<BloodDonor> findByBloodGroup(String group);
	
	public List<BloodDonor> findByAddress(String address);
	
	public BloodDonor findByDonorId(int id);
	
	
	// Update donor using donorId
	@Query(value = "update donors set name=:name ,age=:age ,mobileNumber=:mobileNumber,"
			+ "gender=:gender,bloodGroup=:bloodGroup,email=:email,"
			+ "dateOfBirth=:dateOfBirth,dateOfDonation=:dateOfDonation,address=:address"
			+ " where donorId=:id",nativeQuery=true)
	@Modifying
	@Transactional
	public int updateDonor(@Param("name") String name,
			@Param("age") int age,@Param("mobileNumber") int mobileNumber,
			@Param("gender") String gender,@Param("bloodGroup") String bloodGroup,
			@Param("email") String email,@Param("dateOfBirth") Date dateOfBirth,
			@Param("dateOfDonation") Date dateOfDonation,
			@Param("address") String address,@Param("id") int id);
	
	// show eligible donors
	@Query(value = "select * from donors where dateOfDonation >="
			+ "DATE_SUB(CURDATE(),INTERVAL 6 MONTH)",
							nativeQuery=true)
	public List<BloodDonor> findEligibleDonors();
	
	// show eligible donors using blood group
	@Query(value = "select * from donors where dateOfDonation >="
			+ "DATE_SUB(CURDATE(),INTERVAL 6 MONTH) and bloodGroup=:group",
							nativeQuery=true)
	public List<BloodDonor> findEligibleDonorsByGroup(@Param("group") String group);
}
