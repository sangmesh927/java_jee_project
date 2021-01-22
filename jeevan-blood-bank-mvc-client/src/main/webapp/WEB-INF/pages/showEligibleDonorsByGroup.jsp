<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eligible Donors By Group</title>
<link rel="stylesheet" href="donor.css" />
</head>
<body>
<header>
	<%@ include file="clientMenu.jsp" %>
</header>
<p id="heading">Eligible Donors By Group</p>
	<div name="formToEnterGroup">
		<form action="eligibleDonorByGroup">
		<div>
			<label for="">Select Group</label>
			<select name="group">
				<option value="apos">A+</option>
				<option value="aneg">A-</option>
				<option value="bpos">B+</option>
				<option value="bneg">B-</option>
				<option value="opos">O+</option>
				<option value="oneg">O-</option>
				<option value="abpos">AB+</option>
				<option value="abneg">AB-</option>
			</select>
		</div>
		<div>
			<input type="submit" value="Show Donors" />
		</div>
	</form>
	</div>
	
	<div>
		<table border="1">
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Mobile Number</th>
				<th>Gender</th>
				<th>Blood Group</th>
				<th>Email</th>
				<th>Date of Birth</th>
				<th>Date of Donation</th>
				<th>Address</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="donors" items="${donorsList2}">
				<tr>
					<td>${donors.name}</td>
					<td>${donors.age }</td>
					<td>${donors.mobileNumber }</td>
					<td>${donors.gender }</td>
					<td>${donors.bloodGroup }</td>
					<td>${donors.email }</td>
					<td>${donors.dateOfBirth }</td>
					<td>${donors.dateOfDonation }</td>
					<td>${donors.address }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>