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
<title>Dojo Page</title>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
		<h1 class="text-light mx-3">Dojo and Ninjas</h1>
		<div class="mx-2">
			<a href="/dojos/new" class="btn btn-success">Add New Dojo</a>
			<a href="/ninjas/new" class="btn btn-success mx-3">Add New Ninja</a>
		</div>
	</nav>
	<div class="container my-3 mb-3">
		<h1>${dojos.name} Ninjas</h1>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Age</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${dojos.ninjas}">
					<tr>
						<td><c:out value="${i.first_name }" /></td>
						<td><c:out value="${i.last_name }" /></td>
						<td><c:out value="${i.age }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>