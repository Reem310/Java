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
<title>Book Share</title>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
		<h1 class="text-light mx-3">Book club</h1>
		<div class="d-flex align-items-center mx-3">
			<h6 class="text-light mx-1">Welcome, ${loggedIn }</h6>
			<a href="/books" class="btn btn-outline-success mx-2">Back to book shelf</a>
			<a href="/logout" class="btn btn-outline-danger">Logout</a>
		</div>
	</nav>
	<div class="container my-3 mb-3">
		<h1>Add a Book to Your Shelf!</h1>
		<div class="form-group col-3 mx-4 my-3">
			<form:form action="/books/new" method="post" modelAttribute="book">
				<p>
					<form:label path="title">Title:</form:label>
					<form:input path="title" class="form-control" />
					<form:errors path="title" class="text-danger" />
				</p>
				<p>
					<form:label path="author">Author:</form:label>
					<form:input path="author" class="form-control" />
					<form:errors path="author" class="text-danger" />
				</p>
				<p>
					<form:label path="thoughts">My Thoughts:</form:label>
					<form:textarea path="thoughts" class="form-control" />
					<form:errors path="thoughts" class="text-danger" />
				</p>
				<input type="submit" value="Submit" class="btn btn-primary" />
			</form:form>
		</div>
	</div>
</body>
</html>