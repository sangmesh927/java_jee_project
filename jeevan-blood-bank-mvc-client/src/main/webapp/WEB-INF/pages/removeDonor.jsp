<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove Donor</title>
<link rel="stylesheet" href="donor.css" />
</head>
<body>
<header>
	<%@ include file="menu.html" %>
</header>
<p id="heading">Remove Donor</p>
<p id="mesg">${message2}</p>
<form action="deleteDonor" method="post">
	<div>
		<label for="">Enter Donor Id</label>
	 	<input type="number" name="id" required/>
	</div>
	<div>
		<input type="submit" value="Remove" />
	</div>
</form>

</body>
</html>