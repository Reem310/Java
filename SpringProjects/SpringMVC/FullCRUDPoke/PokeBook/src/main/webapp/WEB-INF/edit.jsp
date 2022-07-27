<%@ page isErrorPage="true"%>
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
<title>Edit My Task</title>
</head>
<body>
	<div class="container col-4">
		<a href="/expenses">Go Back</a>
		<h1>Edit Expense</h1>

		<form:form action="/expenses/${expense.id}/edit" method="post"
			modelAttribute="expense">
			<input type="hidden" name="_method" value="put">
			<p>
				<form:label path="name">Expense Name:</form:label>
				<form:input path="name" class="form-control" />
				<form:errors path="name" class="text-danger" />
			</p>
			<p>
				<form:label path="vendor">Vendor:</form:label>
				<form:input path="vendor" class="form-control" />
				<form:errors path="vendor" class="text-danger" />
			</p>
			<p>
				<form:label path="amount">Amount:</form:label>
				<form:input path="amount" class="form-control" />
				<form:errors path="amount" class="text-danger" />
			</p>
			<p>
				<form:label path="description">Description:</form:label>
				<form:textarea path="description" class="form-control" />
				<form:errors path="description" class="text-danger" />
			</p>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
	</div>
</body>
</html>