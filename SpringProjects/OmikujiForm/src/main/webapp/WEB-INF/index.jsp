<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Omikuji</title>
</head>
<body>
<div class="container my-3">
	<h1 class="mb-3">Send an Omikuji!</h1>
	<form action="omikuji/send" method="post">
	<div class="form-group mb-3">
	<label>Pick any number from 5 to 25</label><br>
	<select name="number">
	<c:forEach var = "i" begin = "5" end = "25">
	<option><c:out value = "${i}"/></option>
	</c:forEach>
	</select>
	</div>
	<div class="form-group mb-3 col-md-5">
	<label>Enter the name of any city.</label>
	<input type="text" class="form-control" name="city">
	</div>
	<div class="form-group mb-3 col-md-5">
	<label>Enter the name of any real person</label>
	<input type="text" class="form-control" name="person">
	</div>
	<div class="form-group mb-3 col-md-5">
	<label>Enter professional endeacor or hobby:</label>
	<input type="text"class="form-control"  name="hobby">
	</div>
	<div class="form-group mb-3 col-md-5">
	<label>Enter any type of living thing.</label>
	<input type="text" class="form-control" name="thing">
	</div>
	<div class="form-group mb-3 col-md-5">
	<label>Say something nice to someone:</label>
	<textarea name="comment" class="form-control" rows="3" placeholder="You do not realize how happy you make others."></textarea>
	</div>
	<p>Send and show a friend</p>
	<div class="form-group mb-3">
	<input type="submit" class="btn btn-dark col-2" value="Send">
	</div>
	</form>
	</div>
</body>
</html>