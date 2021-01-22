<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration for Camp</title>
<link rel="stylesheet" href="donor.css" />
</head>
<body>
<header>
	<%@ include file="menu.html" %>
</header>
<p id="heading">Show Registration For Camps</p>
<div>
	<form action="showRegistrations" method="get">
		<div>
			<label for="">Enter Donor-Id</label>
			<input type="number" name="donorId" required />
		</div>
		<div>
			<input type="submit" name="Show Registrations" />
		</div>	
	</form>	
</div>
<div>
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
				<c:forEach var="camps" items="${registrationList}">
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

</body>
</html>