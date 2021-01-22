<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donors By Area</title>
<link rel="stylesheet" href="donor.css" />
</head>
<body>
<header>
	<%@ include file="clientMenu.jsp" %>
</header>
<p id="heading">Donors By Area</p>
	<div name="formToEnterArea">
		<form action="donorByArea">
		<div>
			<label for="">Select Area</label>
			<select name="area">
				<option value="jaipur">jaipur</option>
				<option value="delhi">delhi</option>
				<option value="jodhpur">jodhpur</option>
				<option value="udaipur">udaipur</option>
				<option value="ajmer">Ajmer</option>
				<option value="amer">Amer</option>
				<option value="gurgaon">Gurgaon</option>
				<option value="noida">Noida</option>
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
			<c:forEach var="donors" items="${donorsList1}">
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