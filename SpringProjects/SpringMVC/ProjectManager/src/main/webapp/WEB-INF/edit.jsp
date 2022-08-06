 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
<title>Create a Task</title>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
		<h1 class="text-light mx-3">Project Manager</h1>
		<div class="d-flex align-items-center mx-3">
			<h6 class="text-light mx-2">Welcome, ${loggedIn.userName }</h6>
			<a href="/logout" class="btn btn-outline-danger">Logout</a>
		</div>
	</nav>
	<div class="container my-3 mb-3">
		<h1>Edit a Project</h1>
		<div class="form-group col-3 mx-4 my-3">
			<form:form action="/projects/edit/${oldProject.id}" method="post" modelAttribute="updatedProject">
			<input type="hidden" name="_method" value="put" />
				<p>
					<form:label path="title">Title:</form:label>
					<form:input path="title" class="form-control" value="${oldProject.title}"/>
					<form:errors path="title" class="text-danger" />
				</p>
				<p>
					<form:label path="description">Description:</form:label>
					<form:input type="textarea" path="description" class="form-control" value="${oldProject.description}"/>
					<form:errors path="description" class="text-danger" />
				</p>
				<p>
	<%-- 				<form:label path="dueDate">Due Date:</form:label>
					<form:input path="dueDate" type="text" class="form-control" value="${oldProject.dueDate}" />
					<form:errors path="dueDate" class="text-danger" /> --%>
					 <form:label path="dueDate" >Due Date: </form:label>
            		<fmt:formatDate pattern = "yyyy-MM-dd" value="${oldProject.dueDate}" var="date"/>
            		<form:input path="dueDate" type="date"  value="${date}" />
            		<form:errors path="dueDate" class="text-danger" />
				</p>
				<input type="submit" value="Submit" class="btn btn-primary" />
			</form:form>
		</div>
	</div>
</body>
</html>