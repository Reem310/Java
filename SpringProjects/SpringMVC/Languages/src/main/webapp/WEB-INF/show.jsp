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
<title>${language.name }</title>
</head>
<body>
	<div class="d-flex container card my-3 mx-4 p-4 w-50 col-4">
		<a href="/languages" class="text-end">Dashboard</a>
		<h1>Language Details</h1>
		<p>
			Name:
			<c:out value="${language.name }"></c:out>
		</p>

		<p>
			Creator:
			<c:out value="${language.creator }"></c:out>
		</p>
		<p>
			Version:
			<c:out value="${language.currentVersion }"></c:out>
		</p>
		<div class="d-flex mb-2">
			<a href="/languages/edit/${language.id }" class="btn text-primary text-decoration-underline">Edit</a>
			<form action="/delete/${language.id}" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					type="submit" value="Delete"
					class="btn text-primary text-decoration-underline">
			</form>
		</div>
	</div>
</body>
</html>