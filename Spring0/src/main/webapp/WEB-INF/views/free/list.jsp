<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/free/list</title>
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
	.pagination{
		width:100px;
		margin:0 auto;
	}
	a{
		text-decoration: none;
	}
</style>
</head>
<body>
	<jsp:include page = "../nav/nav.jsp">
		<jsp:param value = "free" name = "current" />
	</jsp:include>
	
	<div class="container mt-5">
		<h1 align = "center" style = "color:white"> 자유 게시판</h1>
		
		<div class = "row mt-3">
			
			<div class = "col-6">
				<a style = "color:white" href="${pageContext.request.contextPath}/free/insert_form">Insert Page</a>
			</div>
		
			<div class = "container col-6">
				<form action="list" method="get">
					<label for="condition" style = "color:white">검색조건</label>	
					<select name="condition" id="condition">
						<option value="title_content" ${condition eq 'title_content' ? 'selected' : ''}>제목 + 내용</option>
						<option value="title" ${condition eq 'title' ? 'selected' : ''}>제목</option>
						<option value="writer" ${condition eq 'writer' ? 'selected' : ''}>작성자</option>
					</select>
					<input type="text" name="keyword" placeholder="검색어..." value="${keyword}"/>
					<button class = "btn btn-primary" type="submit">검색</button>
				</form>
				<c:if test="${not empty condition}">
					<p style = "color:white">
						<strong>${totalRow}</strong> 개의 자료가 검색 되었습니다.
						<a style = "color:white" href="list">Reset Link</a>
					</p>
				</c:if>
			</div>
		
		<div class = "col-3"></div>
		
		</div>
		
		<table class="table table-light table-striped mt-3">
			<thead>
				<tr>
					<th>글번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tmp" items="${list}">
					<tr>
						<td>${tmp.num}</td>
						<td>${tmp.writer}</td>
						<td>
							<a href="detail?num=${tmp.num}&condition=${condition}&keyword=${encodedK}">${tmp.title}</a>
						</td>
						<td>${tmp.viewCount}</td>
						<td>${tmp.regdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
		<div class = "container">
			<nav>
			<ul class="pagination">
				<c:if test="${startPageNum ne 1}">
					<li class="page-item">
						<a class="page-link  animate__animated" href="list?pageNum=${startPageNum-1}&condition=${condition}&keyword=${encodedK}">Prev</a>
					</li>
				</c:if>
				<c:forEach var="i" begin="${startPageNum}" end="${endPageNum}">
					<li class="page-item ${pageNum eq i ? 'active' : ''}">
						<a class="page-link  animate__animated" href="list?pageNum=${i}&condition=${condition}&keyword=${encodedK}">${i}</a>
					</li>
				</c:forEach>
				<c:if test="${endPageNum lt totalPageCount}">
					<li class="page-item">
						<a class="page-link  animate__animated" href="list?pageNum=${endPageNum+1}&condition=${condition}&keyword=${encodedK}">Next</a>
					</li>
				</c:if>				
			</ul>
		</nav>
		</div>
		
	</div>
</body>
</html>