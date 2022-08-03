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
<title>Product Page</title>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
		<h1 class="text-light mx-3">Product&Category</h1>
		<div>
			<a href="/products/new" class="btn btn-outline-info">Add Product</a>
			<a href="/categories/new" class="btn btn-outline-info mx-2">Add
				category</a>
		</div>
	</nav>
	<div class="container my-3 mb-3">
		<h1>${category.name }</h1>
		<h3>Products:</h3>
		<ul>
			<c:forEach var="product" items="${category.products }">
				<li>${product.name }</li>
			</c:forEach>
		</ul>
		<h3>Add Product:</h3>
		<form action="/categories/${category.id}" method="post">
			<label for="">Product</label> <select name="pid">
				<c:forEach var="i" items="${notInList }">
					<option value="${i.id}">
						<c:out value="${i.name}" />
					</option>
				</c:forEach>
			</select>
			<div class="d-flex justify-content-end my-3">
				<input type="submit" value="Add" class="btn btn-info">
			</div>
		</form>
	</div>
</body>
</html>