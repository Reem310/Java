<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS or jQuery-->
<script type="text/javascript" src="/js/script.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Read Share</title>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
	<div class="d-flex align-items-end">
		<h1 class="text-light mx-3">Book Club</h1>
		<p  class="text-light"> A place for friends to share thoughts on books</p></div>
	</nav>
	<div class="containter mx-auto col-md-7 my-4 d-flex bg-light">
		<div class=" align-items-center container p-5 col-md-7 my-4 ">
			<h3>Registration</h3>
			<br>
			<form:form action="/register" method="post" modelAttribute="newUser">
				<div class="form-group mb-3">
					<label>User Name:</label>
					<form:input path="userName" class="form-control" />
					<form:errors path="userName" class="text-danger" />
				</div>
				<div class="form-group mb-3">
					<label>Email:</label>
					<form:input path="email" class="form-control" />
					<form:errors path="email" class="text-danger" />
				</div>
				<div class="form-group mb-3">
					<label>Password:</label>
					<form:password path="password" class="form-control" />
					<form:errors path="password" class="text-danger" />
				</div>
				<div class="form-group mb-3">
					<label>Confirm Password:</label>
					<form:password path="confirm" class="form-control" />
					<form:errors path="confirm" class="text-danger" />
				</div>
				<input type="submit" value="Register" class="btn btn-primary" />
			</form:form>
		</div>
		 <div class="form-group align-items-start container my-4 p-5 ">
            <h3>Login</h3><br>
		<form:form action="/login" method="post" modelAttribute="newLogin">
			<div class="form-group mb-3">
				<label>Email:</label>
				<form:input path="email" class="form-control" />
				<form:errors path="email" class="text-danger" />
			</div>
			<div class="form-group mb-3">
				<label>Password:</label>
				<form:password path="password" class="form-control" />
				<form:errors path="password" class="text-danger" />
			</div>
			<input type="submit" value="Login" class="btn btn-success" />
		</form:form>
		</div>
	</div>
</body>
</html>

