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
<title>Read Share</title>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
		<h1 class="text-light mx-3">Welcome, ${loggedIn }</h1>
		<div class="d-flex mx-3 p-2">
			<div class="mx-1">
				<a href="/books/new" class="btn btn-success">Add to my shelf</a>
			</div>
			<div class="mx-1">
				<a href="/logout" class="btn btn-success">Logout</a>
			</div>
		</div>
	</nav>
	<div class="container my-4 mb-4">
		<h4 class="mb-3">Books from everyone's shelves</h4>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${books}">
					<tr>
						<td><c:out value="${i.id }" /></td>
						<td><a href="/books/${i.id}"><c:out value="${i.title }" /></a></td>
						<td><c:out value="${i.author }" /></td>
						<td><c:out value="${i.user.userName }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

