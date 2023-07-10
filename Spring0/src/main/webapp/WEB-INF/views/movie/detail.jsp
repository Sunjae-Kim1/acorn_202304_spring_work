<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/movie/detail</title>
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
</style>
</head>
<body>
	<jsp:include page = "../nav/nav.jsp">
		<jsp:param value = "movie" name = "current" />
	</jsp:include>

	<div class = "container mt-5">
		<h1 align = "center" style = "color:white"> 영화 정보 </h1>
		
		<c:choose>
			<c:when test = "${id eq 'aaaa'}">
				<a href="${pageContext.request.contextPath}/movie/update_form?num=${dto.num}" style = "color:white">영화  수정</a>
				<a href="${pageContext.request.contextPath}/movie/delete?num=${dto.num}&writer=${dto.writer}" style = "color:white">영화  삭제</a>
			</c:when>
		</c:choose>
		
		<a href="${pageContext.request.contextPath}/movie/register_form?num=${dto.num}" style = "color:white">영화 예매</a>
		
		<table id = "table" class="table table-light table-striped mt-3">
			<tbody>
				<tr>
					<td>
						<img class="img" src="${pageContext.request.contextPath}${dto.imagePath}"/>
					</td>
				</tr>
				<tr>
					<td>
						제목 : ${dto.caption}
					</td>
				</tr>
				<tr>
					<td>
						업로드 날짜 : ${dto.regdate}
					</td>
				</tr>
			</tbody>
		</table>
		
		<nav>
      <ul class="pagination justify-content-center">
         <c:choose>
            <c:when test="${dto.prevNum ne 0 }">
               <li class="page-item mr-3">
                     <a class="page-link" href="${pageContext.request.contextPath}/movie/detail?num=${dto.prevNum}">&larr; Prev</a>
               </li>
            </c:when>
            <c:otherwise>
               <li class="page-item disabled mr-3">
                     <a class="page-link" href="javascript:">Prev</a>
               </li>
            </c:otherwise>
         </c:choose>
         <c:choose>
            <c:when test="${dto.nextNum ne 0 }">
               <li class="page-item">
                     <a class="page-link" href="${pageContext.request.contextPath}/movie/detail?num=${dto.nextNum}">Next &rarr;</a>
               </li>
            </c:when>
            <c:otherwise>
               <li class="page-item disabled">
                     <a class="page-link" href="javascript:">Next</a>
               </li>
            </c:otherwise>
         </c:choose>         
      </ul>
   </nav>
	</div>
</body>
</html>