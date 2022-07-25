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
<title>Ninja Gold Game</title>
</head>
<body>
	<div class="container my-5">
		<div class="form-group">
			<h1>Your Gold:</h1>
			<input type="number" name="num" disabled
				value="<c:out value="${gold }"></c:out>">
		</div>
		<div class="d-flex justify-content-around">
			<form action="/Gold/form" method="post" class="col-3">
				<div class="form-group card p-2 text-center m-3 m-3">
					<h3>Farm</h3>
					<p>(earns 10-20 gold)</p>
					<input type="hidden" name="place" value="farm"> <input
						type="submit" class="btn btn-dark" value="Find Gold!">
				</div>
			</form>
			<form action="/Gold/form" method="post" class="col-3">
				<div class="form-group card p-2 text-center m-3 m-3">
					<h3>Cave</h3>
					<p>(earns 5-10 gold)</p>
					<input type="hidden" name="place" value="cave"> <input
						type="submit" class="btn btn-dark" value="Find Gold!">
				</div>
			</form>
			<form action="/Gold/form" method="post" class="col-3">
				<div class="form-group card p-2 text-center m-3 m-3">
					<h3>House</h3>
					<p>(earns 2-5 gold)</p>
					<input type="hidden" name="place" value="house"> <input
						type="submit" class="btn btn-dark" value="Find Gold!">
				</div>
			</form>
			<form action="/Gold/form" method="post" class="col-3">
				<div class="form-group card p-2 text-center m-3 m-3">
					<h3>Casino!</h3>
					<p>(earns/takes 0-50 gold)</p>
					<input type="hidden" name="place" value="casino"> <input
						type="submit" class="btn btn-dark" value="Find Gold!">
				</div>
			</form>
		</div>
		<div class="form-group">
			<label for="Activities">Activities: </label><br>
			<div name="log" class="card d-flex p-2">
				<div class="container">
					<div class="overflow-auto p-3 mb-3 mb-md-0 mr-md-3 bg-light"
						style="max-width: 100%; max-height: 200px;">

						<c:forEach var="i" items="${log}">
							<c:choose>
								<c:when test="${i.contains('lost')}">
									<p class="text-danger">
										<c:out value="${i}" />
									</p>
								</c:when>
								<c:otherwise>
									<p class="text-success">
										<c:out value="${i}" />
									</p>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</div>
				</div>
			</div>
			<form action="/Gold/destroy" method="post" class="">
				<button class="btn btn-dark btn-md m-2 col-2">reset</button>
			</form>
		</div>
	</div>
</body>
</html>