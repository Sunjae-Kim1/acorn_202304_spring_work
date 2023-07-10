<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/free/insert_form.jsp</title>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	body{
		background-image: url("../resources/images/movieBackGround.jpg");
		background-size: cover;
	}
	.btn{
		width: 25%;
	}
	.form-control{
		width: 50%;
	}
	.form-label{
		color: white;
		font-size: 20px;
	}
</style>
</head>
<body>
	<jsp:include page = "../nav/nav.jsp">
		<jsp:param value = "free" name = "current" />
	</jsp:include>
	
	<div class="container mt-5">
		<h1 align = "center" style = "color:white">Insert Page</h1>
		<form action="insert" method="post">
			<div class = "mt-5" align = "center">
				<label class = "form-label" for="title">Title</label>
				<input class = "form-control" type="text" name="title" id="title" placeholder = "title"/>
			</div>
			<div align = "center">
				<label class = "form-label" for="content">Content</label>
				<textarea class = "form-control" name="content" id="content" rows="10" placeholder = "Content"></textarea>
			</div>
			<div class = "mt-5" align = "center">
				<button class = "btn btn-primary" type="submit">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>