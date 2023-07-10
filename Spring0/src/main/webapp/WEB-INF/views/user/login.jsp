<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/user/login.jsp</title>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	#body{
		background-image: url("${pageContext.request.contextPath}/resources/images/movieBackGround.jpg");
		background-size: cover;
	}
	.a{
		text-decoration: none;
		color: white;
	}
</style>
</head>
<body id = "body">
	<div class="container mt-5">
		<h1 style="color:white" align = "center">알림</h1>
		<c:choose>
			<c:when test="${not empty sessionScope.id }">
				<p class = "mt-5" align = "center" style="color:white">
					<strong>${sessionScope.id }</strong>님 로그인 되었습니다.
					<br>
					<br>
					<a class = "a" href="${requestScope.url }">돌아가기</a>
				</p>
			</c:when>
			<c:otherwise>
				<p class = "mt-5" align = "center" style="color:white">
					아이디 혹은 비밀 번호가 틀려요
					<br>
					<br>
					<a class = "a" href="login_form?url=${requestScope.encodedUrl }">다시 시도</a>
				</p>
			</c:otherwise>
		</c:choose>
	</div>	
</body>
</html>