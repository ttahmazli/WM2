<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<link href="style.css" rel="stylesheet" />
<body class="body-bg">
	<div class="container-2">
		<h2>Login</h2>
		<form class="login-form" action="Login" method="post">
			<span class="error error-credentials hidden">Invalid
				credentials</span>
			<input class="login-email" type="text" name="email"
				placeholder="Email" required="required">
			<input class="login-pass" type="password" name="password"
				required="required" placeholder="password">
			<a href="register.jsp">Don't have an account?</a>
		</form>
		<button class="btn-login">LOGIN</button>
	</div>
	<script src="script_login.js"></script>
</body>
</html>