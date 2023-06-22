<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/guest/updateform.jsp</title>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class = "container">
		<h1 align = "center"> 회원 정보 수정 폼 </h1>
		<form action = "${pageContext.request.contextPath}/guest/update" method = "post">
			<div>
				<label class = "form-label" for = "num">번호</label>
				<input class = form-control id = "num" name = "num" value = "${dto.num}" readonly/>
			</div>
			<div>
				<label class = "form-label" for = "writer">작성자</label>
				<input class = "form-control" type = "text" id = "writer" name = "writer" value = "${dto.writer}"/>
			</div>
			<div>
				<label class = "form-label" for = "content">내용</label>
				<textarea class = "form-control" type = "text" id = "content" name = "content" cols = "30" rows = "5">${dto.content}</textarea>
			</div>
			<div>
				<label class = "form-label" for = "pwd">비밀번호</label>
				<input class = "form-control" type = "password" id = "pwd" name = "pwd" value = "${dto.pwd}"/>
			</div>
			<div>
				<label class = "form-label" for = "regdate">작성일</label>
				<input class = "form-control" type = "text" id = "regdate" name = "regdate" value = "${dto.regdate}" readonly/>
			</div>
			<div align = "center">
				<button class = "btn btn-outline-primary" type = "submit">수정</button>
				<button class = "btn btn-outline-primary" type = "reset">취소</button>
			</div>
		</form>
	</div>
</body>
</html>