<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/play.jsp</title>
</head>
<body>
	<div class = "cotainer">
		<p> 신나게 놀아요. </p>
		<p> request 영역에 msg 라는 키 값으로 저장된 문자열 : <strong>${msg}</strong> </p>
		<a href = "${pageContext.request.contextPath}/">인덱스로 돌아가기</a>
	</div>
</body>
</html>