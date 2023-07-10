<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/free/update_form.jsp</title>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	body{
		background-image: url("../resources/images/movieBackGround.jpg");
		background-size: cover;
	}
	.form-label{
		color: white;
		font-size: 20px;
	}
	.form-control{
		width: 750px;
	}
	.btn{
		width: 50%;
	}
</style>
</head>
<body>
	<jsp:include page = "../nav/nav.jsp">
		<jsp:param value = "free" name = "current" />
	</jsp:include>

	<div class = "container mt-5">
		<h1 style = "color:white" align = "center">Update Page</h1>
		<form action="update" method="post">
		<div id = "form">
			<input type="hidden" name="num" value="${dto.num}"/>
			<div align = "center">
				<label class = "form-label" for="writer">Writer</label>
				<input class = "form-control" type="text" id="writer" placeholder = "Writer" value="${dto.writer}" readonly/>
			</div>
			<div align = "center">
				<label class = "form-label" for="title">Title</label>
				<input class = "form-control" type="text" name="title" id="title" placeholder = "Title" value="${dto.title}"/>
			</div>
			<div align = "center">
				<label class = "form-label" for="content">Content</label>
				<textarea class = "form-control" name="content" id="content" placeholder = "Content" rows = "5">${dto.content}</textarea>
			</div>
		</div>
		
		<div class = "row mt-5" align = "center">
			<div class = "col-2"></div>
			<div class = "col-4">
				<button class = "btn btn-primary" type="submit">Update</button>
			</div>
			<div class = "col-4">
				<button class = "btn btn-primary" type="reset">Reset</button>
			</div>
			<div class = "col-2"></div>
		</div>
		
	</form>
	</div>
</body>
</html>