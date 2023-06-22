<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/guest/update.jsp</title>
</head>
<body>
	<script>
		alert("${param.writer} 님의 내용이 수정되었습니다.");
		location.href = "${pageContext.request.contextPath}/guest/list";
	</script>
</body>
</html>