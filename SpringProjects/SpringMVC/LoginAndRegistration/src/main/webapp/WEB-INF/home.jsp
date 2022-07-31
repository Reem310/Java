<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS or jQuery-->
<script type="text/javascript" src="/js/script.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Login & Registration</title>
</head>
<body>
	<div
		class="containter card my-3 p-5 bg-light w-50 mx-auto text-center ">
		<h1>Welcome, ${loggedIn }</h1>
		<p>This is your dashboard. Nothing to see here yet.</p>
		<div class="text-center m-3">
			<a href="/logout" class="btn btn-outline-danger w-25 ">Logout</a>
		</div>
	</div>
</body>
</html>

