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
<title>New Product</title>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
		<h1 class="text-light mx-3">Product&Category</h1>
<!-- 			<a href="/books" class="btn btn-outline-success mx-2"></a> -->
	</nav>
	<div class="container my-3 mb-3">
		<h1>Add category</h1>
 		<div class="form-group col-3 mx-4 my-3">
			<form:form action="/categories/new" method="post" modelAttribute="category">
				<p>
					<form:label path="name">name:</form:label>
					<form:input path="name" class="form-control" />
					<form:errors path="name" class="text-danger" />
				</p>
				<input type="submit" value="Add" class="btn btn-primary" />
			</form:form>
		</div> 
	</div>
</body>
</html>