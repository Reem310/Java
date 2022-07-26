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
<title>Books</title>
</head>
<body>
	<div class="container my-3">
		<h1>All Books</h1>
		<table class="table table-hover">
			<thead>
				<tr class="bg-success">
					<th>ID</th>
					<th>Title</th>
					<th>Language</th>
					<th>Number of Pages</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${books }">
					<tr>
						<td><c:out value="${i.id}"></c:out></td>
						<td><c:out value="${i.title}"></c:out></td>
						<td><c:out value="${i.language}"></c:out></td>
						<td><c:out value="${i.numberOfPages}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>