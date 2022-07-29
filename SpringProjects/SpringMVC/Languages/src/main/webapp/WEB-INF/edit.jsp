<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
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
<title>${languages.name}</title>
</head>
<body>
	<div class="container my-3 mb-3 card">
		<div class="d-flex mb-2">
			<form action="/delete/${languages.id}" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					type="submit" value="Delete"
					class="btn text-primary text-decoration-underline">
			</form>
			<a href="/languages" class="btn text-primary text-decoration-underline">Dashboard</a>
		</div>
		<h1>Edit Language:</h1>
		<div class="form-group col-3 mx-4 my-3">
			<form:form action="/languages/edit/${languages.id}" method="post"
				modelAttribute="languages">
				<input type="hidden" name="_method" value="put" />
				<p>
					<form:label path="name">Name:</form:label>
					<form:input path="name" class="form-control" />
					<form:errors path="name" class="text-danger" />
				</p>
				<p>
					<form:label path="creator">Creator:</form:label>
					<form:input path="creator" class="form-control" />
					<form:errors path="creator" class="text-danger" />
				</p>
				<p>
					<form:label path="currentVersion">Version:</form:label>
					<form:input path="currentVersion" class="form-control" />
					<form:errors path="currentVersion" class="text-danger" />
				</p>
				<input type="submit" value="Submit" class="btn btn-primary" />
			</form:form>
		</div>
	</div>
</body>
</html>