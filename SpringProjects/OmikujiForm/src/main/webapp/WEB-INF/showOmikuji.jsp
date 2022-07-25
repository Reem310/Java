<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Omikuji</title>
</head>
<body>
	<div class="container p-4">
		<h1>Here's Your Omikuji!</h1>
		<div class="card border border-3 w-50 p-3 m-2"
			style="background-color: #8FBDD3">
			<c:forEach var="i" items="${forms }">
				<p>
					In
					<c:out value="${i.number }" />
					years, you will live in
					<c:out value="${i.city }" />
					with
					<c:out value="${i.person }" />
					as your roommate,
					<c:out value="${i.hobby }" />
					for living. The next time you see a
					<c:out value="${i.thing }" />
					, you will have good luck. Also,
					<c:out value="${i.comment }" />
					.

				</p>
			</c:forEach>
		</div>
		<a href="/omikuji">Go Back</a>
	</div>
</body>
</html>