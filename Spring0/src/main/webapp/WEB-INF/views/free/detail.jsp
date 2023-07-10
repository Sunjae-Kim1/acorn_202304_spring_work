<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/free/detail.jsp</title>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<style>
	body{
		background-image: url("../resources/images/movieBackGround.jpg");
		background-size: cover;
	}
	.table{
		text-align: center;
	}
	a{
		color: white;
		text-decoration: none;
	}
</style>
</head>
<body>

	<jsp:include page = "../nav/nav.jsp">
		<jsp:param value = "free" name = "current" />
	</jsp:include>

	<div class = "container mt-5">
	<h1 style = "color:white" align = "center">Detail Page</h1>
	
	<c:if test="${sessionScope.id eq dto.writer}">
	
		<div class = "row">
			<div class = "col-1">
         		<a href="update_form?num=${dto.num}">Update</a>
         	</div>
         	<div class = "col-1">
         		<a href="javascript:" onclick="deleteConfirm()">Delete</a>
         	</div>
         </div>
         
         <script>
            function deleteConfirm(){
               const isDelete=confirm("이 글을 삭제 하겠습니까?");
               if(isDelete){
                  location.href="delete?num=${dto.num}";
               }
            }
         </script>
         
	</c:if>
		
      <table class="table table-striped-columns table-light mt-5">
         <tr>
            <th>글번호</th>
            <td>${dto.num}</td>
         </tr>
         <tr>
            <th>작성자</th>
            <td>${dto.writer}</td>
         </tr>
         <tr>
            <th>제목</th>
            <td>${dto.title}</td>
         </tr>
         <tr>
            <th>조회수</th>
            <td>${dto.viewCount}</td>   
         </tr>
         <tr>
            <th>작성일</th>
            <td>${dto.regdate}</td>
         </tr>
         <tr>
            <td colspan="2">
               <div>${dto.content}</div>
            </td>
         </tr>   
      </table>
		
	<div class = "row mt-5" align = "center">
		
		<div class = "col-3"></div>
		
		<div class = "col-3">
		<c:if test="${dto.prevNum ne 0}">
				<a href="detail?num=${dto.prevNum}&condition=${condition}&keyword=${encodedK}">Prev</a>
		</c:if>
		</div>
      
		<div class = "col-3">
			<c:if test="${dto.nextNum ne 0 }">
 					<a href="detail?num=${dto.nextNum}&condition=${condition}&keyword=${encodedK}">Next</a>
			</c:if>
		</div>
      
		<div class = "col-3"></div>
      
	</div>
      
      </div>
</body>
</html>