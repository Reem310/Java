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
<title>Add Song</title>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
		<h1 class="text-light mx-3">Lookify</h1>
		<div class="mx-3">
			<a href="/dashboard" class="btn btn-success">Dashboard</a>
		</div>
	</nav>
	<div class="container card my-3 m-9">
		<div class="m-5 p-2 d-flex justify-content-around">
			<h4>Title: ${show.title}</h4>
			<h4>Artist: ${show.artist}</h4>
			<h4>Rating: ${show.rating} (1-10)</h4>
		</div>
		<div class="text-end mb-3">
			<form action="/delete/${show.id}" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					type="submit" value="Delete" class="btn btn-danger">
			</form>
		</div>
	</div>
</body>
</html>