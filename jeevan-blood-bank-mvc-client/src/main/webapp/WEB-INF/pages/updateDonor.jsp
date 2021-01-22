<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Donor</title>
<link rel="stylesheet" href="donor.css" />
</head>
<body>
<header>
	<%@ include file="menu.html" %>
</header>
<p id="heading">Update Donor</p>
<p id="mesg">${message1}</p>
<form action="thisdonor" method="post">
	<div>
		<label for="">Enter Donor Id</label>
	 	<input type="number" name="id" required/>
	</div>
	<div>
		<input type="submit" value="Show Data" />
	</div>
</form>

</body>
</html>