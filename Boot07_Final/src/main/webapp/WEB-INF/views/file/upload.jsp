<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/file/upload.jsp</title>
</head>
<body>
	<div class = "container">
		<p><strong>${dto.getOrgFileName()}</strong> 파일을 업로드 했습니다.</p>
		<p>저장된 파일 명: <strong>${dto.getSaveFileName()}</strong></p>
		<p>파일의 크기: <strong>${dto.getFileSize()}</strong></p>
		<a href = "download?orgFileName=${dto.getOrgFileName()}&saveFileName=${dto.getSaveFileName()}&fileSize=${dto.getFileSize()}">임시 다운로드</a>
	</div>
</body>
</html>