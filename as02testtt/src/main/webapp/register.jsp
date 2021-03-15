<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<link href="style.css" rel="stylesheet" />
<body class="body-bg">
	<div class="container-2">
		<h2>Register</h2>
		<form class="reg-form" action="Registration" method="post">
			<span class="error error-mail hidden">Invalid email</span>
			<input class="email" type="text" name="email" placeholder="Email"
				required="required">
			<span class="error error-pass hidden">Minimum length should be 4</span>
			<input class="pass" type="password" name="password"
				required="required" placeholder="password">
			<a href="login.jsp">Already have an account?</a>
		</form>
		<button class="btn-reg">REGISTER</button>
	</div>
	<script src="script_reg.js"></script>
</body>
</html>