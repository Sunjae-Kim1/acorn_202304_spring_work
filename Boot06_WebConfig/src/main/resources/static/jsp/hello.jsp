<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/static/jsp/hello.jsp</title>
</head>
<body>
	<div class = "container">
		<h1> JSP 페이지 입니다. </h1>
		<a href = "${pageContext.request.contextPath}/">Index Page</a>
	</div>
</body>
</html>