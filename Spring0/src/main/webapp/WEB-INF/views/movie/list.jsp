<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>movie/list.jsp</title>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
<style>
	.img-wrapper{
      height: 250px;
      transition: transform 0.3s ease-out;
   }
   
   @media(max-width: 575px){
   		.img-wrapper{
   			height: 350px;
   		}
   }
   
   .card .card-text{
      display:block;
      white-space : nowrap;
      text-overflow: ellipsis;
      overflow: hidden;
   }
      .img-wrapper img{
         width: 100%;
         height: 100%;
      	object-fit: cover;   
      }
      .img-wrapper img:hover{
		animation: heartBeat;
		animation-duration: 2s;  
      }

	body{
		background-image: url("../resources/images/movieBackGround.jpg");
		background-size: cover;
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
		<jsp:param value = "movie" name = "current" />
	</jsp:include>

	<div class = "container">
		<h1 align = "center" style = "color:white">Movie Gallery</h1>
		
		<c:choose>
			<c:when test = "${id eq 'aaaa'}">
				<a href="${pageContext.request.contextPath}/movie/upload_form" style = "color:white">영화  추가하기</a>
			</c:when>
		</c:choose>
		<br><br>
		
		<div class="row">
			<c:forEach var="tmp" items="${list}">
         		<div class="col-sm-6 col-md-4 col-lg-3">
               		<div class="card mb-3">
                  		<a href="${pageContext.request.contextPath}/movie/detail?num=${tmp.num}">
                        	<div class="img-wrapper">
                           		<img class="card-img-top" src="${pageContext.request.contextPath }${tmp.imagePath}" />
                        	</div>
                  		</a>
                  		<div class="card-body">
                    		<p class="card-text" align = "center"><strong>${tmp.caption}</strong></p>
                        	<p>업로드 날짜 : ${tmp.regdate}</p>
                  		</div>
               		</div>
            	</div>
      		</c:forEach>
		</div>
		
		<div class = "container">
			<nav>
			<ul class="pagination">
				<c:if test="${startPageNum ne 1}">
					<li class="page-item">
						<a class="page-link  animate__animated" href="list?pageNum=${startPageNum-1}">Prev</a>
					</li>
				</c:if>
				<c:forEach var="i" begin="${startPageNum}" end="${endPageNum}">
					<li class="page-item ${pageNum eq i ? 'active' : ''}">
						<a class="page-link  animate__animated" href="list?pageNum=${i}">${i}</a>
					</li>
				</c:forEach>
				<c:if test="${endPageNum lt totalPageCount}">
					<li class="page-item">
						<a class="page-link  animate__animated" href="list?pageNum=${endPageNum+1}">Next</a>
					</li>
				</c:if>				
			</ul>
		</nav>
		</div>
		
		
	</div>
</body>
</html>