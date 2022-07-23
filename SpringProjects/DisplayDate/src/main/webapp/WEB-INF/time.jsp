<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/script2.js"></script>
<meta charset="UTF-8">
<title>Time</title>
</head>
<body>
 <h1 class="time"><fmt:formatDate pattern = "HH:mm a"  value = "${date}" /></h1>
</body>
</html>