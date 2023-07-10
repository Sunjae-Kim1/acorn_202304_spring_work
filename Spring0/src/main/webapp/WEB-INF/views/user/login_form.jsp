<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/user/login_form.jsp</title>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	#body{
		background-image: url("${pageContext.request.contextPath}/resources/images/movieBackGround.jpg");
		background-size: cover;
	}
	.form-control{
		width: 50%;
		margin: 0 auto;
	}
	.btn{
		width: 25%;
	}
</style>
</head>
<body id = "body">
	<jsp:include page = "../nav/nav.jsp">
		<jsp:param value = "value" name = "current" />
	</jsp:include>

	<div class="container mt-5">
		<h1 align = "center" style="color:white">Login</h1>
		<form action="${pageContext.request.contextPath}/user/login" method="post">
			<c:choose>
				<c:when test="${ empty param.url }">
					<input type="hidden" name="url" value="${pageContext.request.contextPath}/"/>
				</c:when>
				<c:otherwise>
					<input type="hidden" name="url" value="${param.url }"/>
				</c:otherwise>
			</c:choose>
			<div>
				<input class="form-control mt-5" type="text" name="id" id="id" placeholder="ID"/>
			</div>
			<div>
				<input class="form-control mt-5" type="password" name="pwd" id="pwd" placeholder="PassWord"/>
			</div>
			<div align = "center">
				<button class="btn btn-primary mt-5" type="submit">Login</button>
			</div>
		</form>
	</div>
</body>
</html>