<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/user/signup_form.jsp</title>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	#body{
		background-image: url("${pageContext.request.contextPath}/resources/images/movieBackGround.jpg");
		background-size: cover;
	}
	.input{
		text-decoration: underline;
	}
	.form-control{
		width: 50%;
		margin: 0 auto;
	}
	.btn{
		width:25%;
	}
</style>
</head>
<body id = "body">
	<jsp:include page = "../nav/nav.jsp">
		<jsp:param value = "value" name = "current" />
	</jsp:include>

	<div class="container mt-5">
		<h1 align = "center" style="color:white">SignUp</h1>
		<form action="${pageContext.request.contextPath}/user/signup" method="post" id="myForm">
		
			<div class = "mt-5">
				<input class = "form-control" type="text" name="id" id="id" placeholder = "ID"/>
			</div>
			<div class = "mt-5"><span id="result_checkId" style="font-size:12px;"></span></div>
			<div class = "mt-5">
				<input class="form-control" type="password" name="pwd" id="pwd" placeholder = "PassWord"/>	
			</div>
			<div class = "mt-5">
				<input class="form-control" type="password" name="pwd2" id="pwd2" placeholder = "PassWord2"/>
			</div>
			<div class = "mt-5">
				<input class="form-control" type="text" name="email" id="email" placeholder = "Email"/>
			</div>
			<div align = "center">
				<button class="btn btn-primary mt-5" type="submit">SignUp</button>
			</div>
			
		</form>
	</div>	
</body>
</html>