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
<title>Lookify!</title>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
		<h1 class="text-light mx-3">Lookify</h1>
		<div class="d-flex mx-3 p-2">
			<div class="mx-1">
				<a href="/dashboard" class="btn btn-success">Dashboard</a>
			</div>
			<form action="/search" method="post" class="form-inline d-flex">
				<input class="form-control mr-sm-2 mx-2" type="search"
					placeholder="Search" name="artist" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<div class="container my-4 mb-4">
		<h1>Top Ten Songs:</h1>
		<table class="table table-striped table-hover">
				<c:forEach var="i" items="${top}">
					<tr>
					<td><c:out value="${i.rating }" /></td>
					<td><a href="/songs/${i.id}"><c:out value="${i.title }" /></a></td>
					<td><c:out value="${i.artist }" /></td>
					</tr>
				</c:forEach>
		</table>
	</div>
</body>
</html>