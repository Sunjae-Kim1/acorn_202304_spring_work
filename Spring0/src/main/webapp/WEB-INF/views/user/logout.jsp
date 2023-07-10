<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/user/logout.jsp</title>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	#body{
		background-image: url("${pageContext.request.contextPath}/resources/images/movieBackGround.jpg");
		background-size: cover;
	}
</style>
</head>
<body id = "body">
	<script>
		alert("로그아웃 되었습니다.");
		location.href="${pageContext.request.contextPath}/";
	</script>
</body>
</html>