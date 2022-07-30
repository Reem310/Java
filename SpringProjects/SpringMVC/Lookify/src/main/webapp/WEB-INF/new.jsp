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
<title>Add Song</title>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
		<h1 class="text-light mx-3">Lookify</h1>
		<div class="mx-3">
			<a href="/dashboard" class="btn btn-success">Dashboard</a>
		</div>
	</nav>
	<div class="container my-3 mb-3">
		<div class="form-group col-3 mx-4 my-4">
			<form:form action="/songs/new" method="post" modelAttribute="songs">
				<p>
					<form:label path="title">Title:</form:label>
					<form:input path="title" class="form-control" />
					<form:errors path="title" class="text-danger" />
				</p>
				<p>
					<form:label path="artist">Artist:</form:label>
					<form:input path="artist" class="form-control" />
					<form:errors path="artist" class="text-danger" />
				</p>
				<p>
					<form:label path="rating">Rating:</form:label>
					<form:select path="rating">
						<c:forEach begin="1" end="10" varStatus="loop">
							<form:option path="rating" value="${loop.index}"></form:option>
						</c:forEach>
					</form:select>
				</p>
				<div class="text-end">
				<input type="submit" value="Submit" class="btn btn-outline-success" /></div>
			</form:form>
		</div>
	</div>
</body>
</html>