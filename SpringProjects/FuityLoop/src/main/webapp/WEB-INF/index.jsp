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
<title>Fruity Loops</title>
</head>
<body class="container my-3">
	<h1>Fruit Store</h1>
	<table class="table table-hover">
		<thead class="table-primary">
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="items" items="${fruits}">
				<tr>
					<td>
						<p>
							<c:out value="${items.name}"></c:out>
						</p>
					</td>
					<td>
						<p>
							<c:out value="${items.price}"></c:out>
						</p>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
