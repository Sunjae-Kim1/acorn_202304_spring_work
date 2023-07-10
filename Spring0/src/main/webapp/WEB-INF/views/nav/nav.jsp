<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 어두운 색 계열의 navbar 배경색이면 data-bs-theme="dark" 속성 적용 -->
	<!-- navbar-expand-md 는 md 영역 이상에서 navbar-collapse 가 펼쳐 지도록 한다. -->
	<nav class="navbar bg-dark navbar-expand-md" data-bs-theme="dark">
  		<div class="container">
    		<a class="navbar-brand" href="${pageContext.request.contextPath}/">
      		<img src="${pageContext.request.contextPath}/resources/images/logo.PNG" alt="Logo" width="40" height="40" class="d-inline-block align-text-top">
			Spring Movie
    		</a>
    		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText">
            	<span class="navbar-toggler-icon"></span>
       		</button>
       		
       		<div class="collapse navbar-collapse" id="navbarText">
            	<ul class="navbar-nav me-auto">
              		<li class="nav-item">
                   		<a class="nav-link ${param.current eq 'movie' ? 'active' : ''}" href="${pageContext.request.contextPath}/movie/list"> movie</a>
              		</li>
              		<li class="nav-item">
                   		<a class="nav-link ${param.current eq 'free' ? 'active' : ''}" href="${pageContext.request.contextPath}/free/list">자유 게시판</a>
              		</li>
            	</ul>
            	
            	<div class = "navbar-nav">
            		<c:choose>
            			<c:when test = "${not empty id}">
            					<strong><a class = "nav-link" href = "${pageContext.request.contextPath}/user/info">${id} 님 로그인 중</a></strong>
            					<a class = "nav-link" href = "${pageContext.request.contextPath}/user/logout">Logout</a>
            			</c:when>
            			<c:otherwise>
            				<a class = "nav-link" href = "${pageContext.request.contextPath}/user/login_form">Login</a>
            				<a class = "nav-link" href = "${pageContext.request.contextPath}/user/signup_form">SignUp</a>
            			</c:otherwise>
            		</c:choose>
            	</div>
            	
       		</div>
       		
       		<c:set var="today" value="<%=new java.util.Date()%>" />
			<!-- 현재날짜 -->
			<c:set var="date"><fmt:formatDate value="${today}" pattern="yyyy-MM-dd" /></c:set>
			<div style = "color:white">
       			<c:out value="${date}" />
       		<br>
       		<h5 class = "h1-clock" style = "color:white"></h5>
            <script src = "${pageContext.request.contextPath}/resources/js/clock.js"></script>
            </div>
    	</div>
	</nav>