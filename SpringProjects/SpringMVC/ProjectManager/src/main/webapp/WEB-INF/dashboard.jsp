<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS or jQuery-->
<script type="text/javascript" src="/js/script.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Project Manager Dashboard</title>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
		<h1 class="text-light mx-3">Project Manager</h1>
		<div class="d-flex align-items-center mx-3">
			<h6 class="text-light mx-1">Welcome, ${loggedIn.userName }</h6>
			<a href="/projects/new" class="btn btn-outline-success mx-2">+ new project</a> 
			<a href="/logout" class="btn btn-outline-danger">Logout</a>
		</div>
	</nav>
	<div class="container my-4 mb-4">
		<h4 class="mb-3">All Projects</h4>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${allP}">
					<c:if test="${i.creator.id != null}">
						<tr>
							<td><a href="/projects/${i.id}"><c:out value="${i.title }" /></a></td>
							<td><c:out value="${i.creator.userName }" /></td>
							<td><fmt:formatDate pattern = "MMM dd" value = "${i.dueDate}" /></td>
							<td><c:choose>
									<c:when test="${loggedIn.id == i.creator.id}">
										<div class="d-flex">
											<a href="/projects/edit/${i.id}" class="btn btn-primary px-4">Edit</a>
											<form action="/delete/${i.id}" method="post">
												<input type="hidden" name="_method" value="delete">
												<input type="submit" value="Delete"
													class="btn btn-danger mx-2">
											</form>
										</div>
									</c:when>
									<c:when
										test="${notj != null && i.users != project_id }">
										<!-- i.users != i.creator -->
										<form action="/join/${i.id}" method="post">
 											<input type="hidden" name="uid" value="${user_id}"/>
											<input type="submit" value="Join Team" class="btn btn-primary">
										</form>
									</c:when> 
<%-- 									<c:when test="${loggedIn.id != i.creator.id && project_id==null}">
										<form action="/join/${i.id}" method="post">
										<input type="hidden" name="uid" value="${user_id}"/>
											<input type="submit" value="Join Team" class="btn btn-primary">
										</form>
									</c:when>  --%>
																		<c:when
										test="${notj == null && i.users == project_id }">
										<!-- i.users != i.creator -->
										<form action="/join/${i.id}" method="post">
 											<input type="hidden" name="uid" value="${user_id}"/>
											<input type="submit" value="Join Team" class="btn btn-primary">
										</form>
									</c:when> 
									<c:otherwise>
										<strong>Joined</strong>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
		<h5 class="my-4 mb-3">Your Projects</h5>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>Project</th>
					<th>Team Lead</th>
					<th>Due Date</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="i" items="${joined}">
					<tr>
						<c:if test="${user_id == loggedIn.id && i.creator.id != user_id}">
							<td><a href="/projects/${i.id}"><c:out value="${i.title }" /></a></td>
							<td><c:out value="${i.creator.userName }" /></td>
							<td><fmt:formatDate pattern = "MMM dd" value = "${i.dueDate}" /></td>
							<td>
								<form action="/leave/${i.id}" method="post">
									<input type="hidden" name="_method" value="put"> <input
										type="submit" value="Leave Team" class="btn btn-danger mx-2">
								</form>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>

