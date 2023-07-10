<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/user/delete.jsp</title>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	#body{
		background-image: url("${pageContext.request.contextPath}/resources/images/movieBackGround.jpg");
		background-size: cover;
	}
</style>
</head>
<body  id = "body">
	<div class="container">
		<h1 style="color:white">알림</h1>
		<p style="color:white">
			<strong>${requestScope.id }</strong> 님 탈퇴 처리 되었습니다.
			<a href="${pageContext.request.contextPath}/">인덱스로 가기</a>
		</p>
	</div>
</body>
</html>