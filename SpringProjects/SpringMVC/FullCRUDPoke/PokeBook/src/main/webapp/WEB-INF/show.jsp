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
<title>Show Expense</title>
</head>
<body>
	<div class="d-flex container card my-3 mx-4 p-4 w-50 col-4">
		<a href="/expenses" class="text-end">Go Back</a>
		<h1>Expense Details</h1>
		<p>
			Expense Name:
			<c:out value="${expense.name }"></c:out>
		</p>

		<p>
			Expense Description:
			<c:out value="${expense.description }"></c:out>
		</p>
		<p>
			Vendor:
			<c:out value="${expense.vendor }"></c:out>
		</p>
		<p>
			Amount Spent:
			<c:out value="${expense.amount }"></c:out>
		</p>
	</div>
</body>
</html>