<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/user/info.jsp</title>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	#profileImage{
		width: 100px;
		height: 100px;
		border: 1px solid #cecece;
		border-radius: 50%;
	}
	#table{
		margin-left: auto;
    	margin-right: auto;
		width: 500px;
		height: 300px;
		text-align: center;
	}
	#body{
		background-image: url("${pageContext.request.contextPath}/resources/images/movieBackGround.jpg");
		background-size: cover;
	}
	#a1{
		text-decoration: none;
	}
	#a2{
		text-decoration: none;
	}
</style>
</head>
<body id = "body">
	<jsp:include page = "../nav/nav.jsp">
		<jsp:param value = "value" name = "current" />
	</jsp:include>

	<div class="container mt-5">
	<h1 align = "center" style="color:white">개인 정보</h1>
	<table class="table table-light table-striped mt-3" id = "table">
		<tr>
			<th>아이디</th>
			<td>${id }</td>
		</tr>
		<tr>
			<th>프로필 이미지</th>
			<td>
			<c:choose>
				<c:when test="${empty dto.profile}">
					<svg id="profileImage" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
					  <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
					  <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
					</svg>
				</c:when>
				<c:otherwise>
					<img id="profileImage" 
						src="${pageContext.request.contextPath}${dto.profile}"/>
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${dto.email}</td>
		</tr>
		<tr>
			<th>가입일</th>
			<td>${dto.regdate}</td>
		</tr>
	</table>
	<div class = "row" align = "center">
		<div class = "col-3"></div>
		<div class = "col-3">
			<a id = "a1" href="${pageContext.request.contextPath}/user/update_form" style="color:white">Profile Update</a>
		</div>
		<div class = "col-3">
			<a id = "a2" href="javascript:deleteConfirm()" style="color:white">탈퇴</a>
		</div>
		<div class = "col-3"></div>
	</div>
</div>
<script>
	function deleteConfirm(){
		const isDelete=confirm("${id} 님 탈퇴 하시겠습니까?");
		if(isDelete){
			location.href="${pageContext.request.contextPath}/user/delete";
		}
	}
</script>
</body>
</html>