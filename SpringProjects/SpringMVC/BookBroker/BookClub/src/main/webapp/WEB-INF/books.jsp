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
		<h1 class="text-light mx-3">Book club</h1>
		<div class="d-flex align-items-center mx-3">
			<h6 class="text-light mx-1">Welcome, ${loggedIn.userName }</h6>
			<a href="/books/new" class="btn btn-outline-success mx-2">Add to
				my shelf</a> <a href="/logout" class="btn btn-outline-danger">Logout</a>
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
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${books}">
					<c:if test="${i.user.id != null }">
						<tr>
							<td><c:out value="${i.id }" /></td>
							<td><a href="/books/${i.id}"><c:out value="${i.title }" /></a></td>
							<td><c:out value="${i.author }" /></td>
							<td><c:out value="${i.user.userName }" /></td>
							<td><c:choose>
									<c:when test="${loggedIn.id == i.user.id}">
										<div class="d-flex">
											<a href="/books/${i.id}/edit" class="btn btn-primary px-4">Edit</a>
											<form action="/delete/${i.id}" method="post">
												<input type="hidden" name="_method" value="delete">
												<input type="submit" value="Delete"
													class="btn btn-danger mx-2">
											</form>
										</div>
									</c:when>
									<c:when
										test="${loggedIn.id != i.user.id && i.borrower.id == null}">
										<form action="/borrow/${i.id}" method="post">
											<input type="submit" value="Borrow" class="btn btn-primary">
										</form>
									</c:when>
									<c:otherwise>
										<strong>BORROWED</strong>
									</c:otherwise>
								</c:choose></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
		<h5 class="my-4 mb-3">Books I'm Borrowing..</h5>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author Name</th>
					<th>Posted By</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${borrowed}">
					<tr>
						<c:if test="${i.borrower.id == loggedIn.id}">
							<td><c:out value="${i.id }" /></td>
							<td><a href="/books/${i.id}"><c:out value="${i.title }" /></a></td>
							<td><c:out value="${i.author }" /></td>
							<td><c:out value="${i.user.userName }" /></td>
							<td>
								<form action="/return/${i.id}" method="post">
									<input type="hidden" name="_method" value="put"> <input
										type="submit" value="Return" class="btn btn-danger mx-2">
								</form>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

