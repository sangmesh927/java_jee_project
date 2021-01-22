<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Donors</title>
<link rel="stylesheet" href="donor.css" />
</head>
<body>
<header>
	<%@ include file="clientMenu.jsp" %>
</header>
<p id="heading">Donors</p>
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
			<c:forEach var="donors" items="${donorsList}">
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
</body>
</html>