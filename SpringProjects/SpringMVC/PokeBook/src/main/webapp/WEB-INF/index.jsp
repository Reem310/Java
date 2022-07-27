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
	<div class="container my-3 mb-3">
	<h1>Poke Book</h1>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${expenses}">
					<tr>
						<td><c:out value="${i.name }" /></td>
						<td><c:out value="${i.vendor }" /></td>
						<td><c:out value="${i.amount }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<h3>Track an Expense:</h3>
		<div class="form-group col-3 mx-4 my-3">
			<form:form action="/send" method="post" modelAttribute="expense">
				<p>
					<form:label path="name">Expense Name:</form:label>
					<form:input path="name" class="form-control"/>
					<form:errors path="name" class="text-danger" />
				</p>
				<p>
					<form:label path="vendor">Vendor:</form:label>
					<form:input path="vendor" class="form-control"/>
					<form:errors path="vendor" class="text-danger" />
				</p>
				<p>
					<form:label path="amount">Amount:</form:label>
					<form:input path="amount" class="form-control"/>
					<form:errors path="amount" class="text-danger" />
				</p>
				<p>
					<form:label path="description">Description:</form:label>
					<form:input path="description" class="form-control"/>
					<form:errors path="description" class="text-danger" />
				</p>
				<input type="submit" value="Submit" class="btn btn-dark" />
			</form:form>
		</div>
	</div>
</body>
</html>