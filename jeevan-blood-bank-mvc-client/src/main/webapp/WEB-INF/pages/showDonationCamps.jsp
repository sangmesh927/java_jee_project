<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Donation Camps</title> 
<link rel="stylesheet" href="donor.css" />
</head>
<body>
<header>
	<%@ include file="menu.html" %>
</header>
<p id="heading">Donation Camps</p>
<div id="content">
	<table border="1">
	<thead>
		<tr>
			<th>Camp Id</th>
			<th>Camp Name</th>
			<th>Camp Location</th>
			<th>Camp Date</th>
			<th>Camp Start Time</th>
			<th>Camp End Time</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="camps" items="${list}">
			<tr>
				<td>${camps.campId}</td>
				<td>${camps.campName }</td>
				<td>${camps.campLocation }</td>
				<td>${camps.campDate }</td>
				<td>${camps.campStartTime }</td>
				<td>${camps.campEndTime }</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</div>
<h2>Donor registration for Camp</h2>
<div id="registrationForm">
	<form action="register" method="post">
		<div>
			<label for="">Enter your Donor-Id</label>
	 		<input type="number" name="donorId" required/>
		</div>
		<div>
			<label for="">Select Camp-Id to register</label>
			<select name="campId">
				<c:forEach var="camps" items="${list}">
					<option value="${camps.campId}">${camps.campId}</option>>
				</c:forEach>
			</select>
		</div>
		<div>
			<input type="submit" value="Register" />
		</div>
	</form>
</div>
</body>
</html>