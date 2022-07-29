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
<title>Languages</title>
</head>
<body>
	<div class="container my-3 mb-3">
		<h1>Languages</h1>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Creator</th>
					<th>Version</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${language}">
					<tr>
						<td><a href="/languages/${i.id}"><c:out
									value="${i.name }" /></a></td>
						<td><c:out value="${i.creator }" /></td>
						<td><c:out value="${i.currentVersion }" /></td>
						<td class="d-flex"><a href="/languages/edit/${i.id }"
							class="btn btn-primary mx-2">Edit</a>
							<form action="/delete/${i.id}" method="post">
								<input type="hidden" name="_method" value="delete"> <input
									type="submit" value="Delete" class="btn btn-danger">
							</form></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3>Add a Language:</h3>
		<div class="form-group col-3 mx-4 my-3">
			<form:form action="/languages" method="post"
				modelAttribute="languages">
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