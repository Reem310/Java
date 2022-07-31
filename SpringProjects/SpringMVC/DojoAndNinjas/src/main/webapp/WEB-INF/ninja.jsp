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
<title>New Ninja</title>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
		<h1 class="text-light mx-3">Dojo and Ninjas</h1>
		<div class="mx-2">
			<a href="/dojos/new" class="btn btn-success mx-3">Add New Dojo</a>
		</div>
	</nav>
	<div class="container my-3 mb-3">
		<h1>New ninja</h1>
		<div class="form-group col-3 mx-4 my-3">
			<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
				<p>
					<form:label path="dojo">Dojo:</form:label>
					<form:select path="dojo">
						<c:forEach var="dojo" items="${dojos}">
							<form:option value="${dojo.id}">
								<c:out value="${dojo.name}" />
							</form:option>
						</c:forEach>
					</form:select>
				</p>
				<p>
					<form:label path="first_name">First Name:</form:label>
					<form:input path="first_name" class="form-control" />
					<form:errors path="first_name" class="text-danger" />
				</p>
				<p>
					<form:label path="last_name">Last Name:</form:label>
					<form:input path="last_name" class="form-control" />
					<form:errors path="last_name" class="text-danger" />
				</p>
				<p>
					<form:label path="age">Age:</form:label>
					<form:input path="age" class="form-control" />
					<form:errors path="age" class="text-danger" />
				</p>
				<input type="submit" value="Create" class="btn btn-primary" />
			</form:form>
		</div>
	</div>
</body>
</html>