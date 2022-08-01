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
		<h1 class="text-light mx-3">Book Club</h1>
		<div class="d-flex align-items-center mx-3">
			<h6 class="text-light mx-1">Welcome, ${loggedIn }</h6>
			<a href="/books" class="btn btn-outline-success mx-2">Back to book shelf</a>
			<a href="/logout" class="btn btn-outline-danger">Logout</a>
		</div>
	</nav>
	<div class="container my-3 mb-3">
		<h1>${book.title}</h1>
		<c:choose>
			<c:when test="${book.user.id == user_id}"><h6><span class="text-success">You</span> read
			<c:out value="${book.title }" /> by <c:out value="${book.author }" /> </h6>
			<p>Here are your thoughts:</p></c:when>
			<c:otherwise><span class="text-success"><c:out value="${book.user.userName}"/></span> read <c:out value="${book.title }" /> by <c:out value="${book.author }" /> 
			<p>Here are <c:out value="${book.user.userName }" />'s thoughts:</c:otherwise>
		</c:choose>
		
		<hr>
		<p class="m-3 p-4">
			<c:out value="${book.thoughts }" />
		</p>
		<hr>
		<c:if test="${user_id == book.user.id}">
			<form class="d-flex align-items-center justify-content-end"
				action="/books/${id}/edit" method="post">
				<input type="hidden" name="_method" value="put">
				<input type="submit" class="btn btn-primary" value="Edit">
			</form>
		</c:if>
	</div>
</body>
</html>