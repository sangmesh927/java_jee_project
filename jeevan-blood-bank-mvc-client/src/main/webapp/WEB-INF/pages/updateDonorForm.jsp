<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Donor Form</title>
<link rel="stylesheet" href="donor.css" />
<style type="text/css">
	#id{
	visibility : hidden;
	}
</style>
</head>
<body>
<header>
	<%@ include file="menu.html" %>
</header>
<p id="heading">Update Donor</p>
<p id="mesg">${message1} </p>
<form:form action="blooddonor" post="POST">
	<div>
	 	<form:input type="number" id="id" path="donorId" />
	 	
	</div>
	<div>
		<label for="">Name</label>
	 	<form:input path="name" required="required" />
	</div>
	<div>
		<label for="">Age</label>
	 	<form:input type="number" path="age" required="required"/>
	</div>
	<div>
		<label for="">Mobile Number</label>
	 	<form:input type="number" path="mobileNumber" required="required"/>
	</div>
	<div>
		<label for="">Gender</label>
	 	<form:select path="gender">
	 		<form:option value="male" label="Male" />
	 		<form:option value="female" label="Female" />
	 	</form:select>
	</div>
	<div>
		<label for="">Blood Group</label>
	 	<form:select path="bloodGroup">
	 		<form:option value="apos" label="A+" />
	 		<form:option value="aneg" label="A-" />
	 		<form:option value="bpos" label="B+" />
	 		<form:option value="bneg" label="B-" />
	 		<form:option value="opos" label="O+" />
	 		<form:option value="oneg" label="O-" />
	 		<form:option value="abpos" label="AB+" />
	 		<form:option value="abneg" label="AB-" />
	 	</form:select>
	</div>
	<div>
		<label for="">Email</label>
	 	<form:input path="email" required="required"/>
	</div>
	<div>
		<label for="">Date of Birth</label>
		<form:input path="dateOfBirth" required="required"/>
	</div>
	<div>
		<label for="">Date of Donation</label>
		<form:input path="dateOfDonation" required="required"/>
	</div>
	<div>
		<label for="">Address</label>
	 	<form:select path="address">
	 		<form:option value="jaipur" label="Jaipur" />
	 		<form:option value="delhi" label="Delhi" />
	 		<form:option value="jodhpur" label="Jodhpur" />
	 		<form:option value="udaipur" label="Udaipur" />
	 		<form:option value="ajmer" label="Ajmer" />
	 		<form:option value="amer" label="Amer" />
	 		<form:option value="gurgaon" label="Gurgaon" />
	 		<form:option value="noida" label="Noida" />
	 	</form:select>
	</div>
	<div>
		<input type="submit" value="Update">
	</div>
</form:form>
</body>
</html>