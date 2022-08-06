<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
<title>Project Details</title>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
		<h1 class="text-light mx-3">Project Manager</h1>
		<div class="d-flex align-items-center mx-3">
			<h6 class="text-light mx-2">Welcome, ${loggedIn.userName }</h6>
			<a href="/dashboard" class="btn btn-outline-success mx-2">Dashboard</a>
			<a href="/logout" class="btn btn-outline-danger">Logout</a>
		</div>
	</nav>
	<div class="card my-3 mb-3 mx-5 p-4">
		<p><h5>Project:</h5> ${pDetails.title}</p>
		<p><h5>Description: </h5><c:out value="${pDetails.description }" /></p>
		<p><h5>Due Date:</h5><fmt:formatDate pattern = "M-d-yyyy" value = "${pDetails.dueDate}" /></p>
		<c:if test="${user_id == pDetails.creator.id}">
			<form class="d-flex align-items-center justify-content-end"
				action="/delete/${id}" method="post">
				<input type="hidden" name="_method" value="delete">
				<input type="submit" class="btn btn-danger" value="Delete Project">
			</form>
		</c:if>
	</div>
</body>
</html>