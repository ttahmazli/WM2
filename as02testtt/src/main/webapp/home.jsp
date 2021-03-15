<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personal Cabinet</title>
</head>
<link href="style.css" rel="stylesheet" />
<body class="body-bg">
	<div class="container-2">
		<h2>Student Info</h2>
		<form class="update-form" action="Info" method="post">
			<input type="text" name="firstName"
				value=<%=request.getSession().getAttribute("firstName")%>
				placeholder="First Name">
			<input type="text" name="lastName"
				value=<%=request.getSession().getAttribute("lastName")%>
				placeholder="Last Name">
			<input type="number" name="age" class="age"
				value=<%=request.getSession().getAttribute("age")%>
				placeholder="Age">
			<input type="text" name="city"
				value=<%=request.getSession().getAttribute("city")%>
				placeholder="City">
			<input type="text" name="country"
				value=<%=request.getSession().getAttribute("country")%>
				placeholder="Country">
		</form>
		<button class="btn-update">Update</button>
		<a href="login.jsp">Log Out</a>
	</div>
	<script src="script_update.js"></script>
</body>
</html>