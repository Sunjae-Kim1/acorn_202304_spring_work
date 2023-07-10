<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/movie/update_form.jsp</title>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	body{
		background-image: url("../resources/images/movieBackGround.jpg");
		background-size: cover;
	}
	#table{
		margin-left: auto;
    	margin-right: auto;
		width: 500px;
		height: 300px;
		text-align: center;
	}
	.img{
		width: 300px;
		height: 300px;
	}
	.btn{
		width:25%;
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
	<jsp:include page = "../nav/nav.jsp">
		<jsp:param value = "movie" name = "current" />
	</jsp:include>
	
	<div class = "container mt-5">
		<h1 align = "center" style = "color:white">수정할 영화 정보 </h1>
		
		<form action="${pageContext.request.contextPath}/movie/update?num=${dto.num}" method="post">
		<table id = "table" class="table table-light table-striped mt-5">
			<tbody>
				<tr>
					<td colspan = "2">
						<img class="img" src="${pageContext.request.contextPath}${dto.imagePath}"/>
					</td>
				</tr>
				<tr>
					<th>
						제목
					</th>
					<td>
						<input type = "text" id = "caption" name = "caption" placeholder = "${dto.caption}"/>
					</td>
				</tr>
				<tr>
					<th>
						업로드 날짜
					</th>
					<td>
						<input readonly type = "text" id = "regdate" name = "regdate" placeholder = "업로드 날짜" value = "${dto.regdate}"/>
					</td>
				</tr>
			</tbody>
		</table>
		<div align = "center">
				<button class="btn btn-primary mt-5" type="submit">Update</button>
		</div>
		</form>
		
		<br><br>
		<div align = "center">
			<a style = "color:white" href = "${pageContext.request.contextPath}/movie/detail?num=${dto.num}">Go Back</a>
		</div>
	</div>
</body>
</html>