<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"/>
<style>
	#carousel{
		width:700px;
		margin-left: auto;
    	margin-right: auto;
	}
	.carousel-item > .d-block{
		height:500px;
	}
	.carousel-item > .d-block:hover{
		animation: heartBeat;
		animation-duration: 2s;
	}
	body{
		background-image: url("resources/images/movieBackGround.jpg");
		background-size: cover;
	}
</style>
</head>
<body>

	<jsp:include page = "nav/nav.jsp">
		<jsp:param value = "value" name = "current" />
	</jsp:include>

	<div class = "container" id = "carousel">
	<div id="carouselExampleCaptions" class="carousel slide">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="3" aria-label="Slide 4"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="4" aria-label="Slide 5"></button>
  </div>
  <div class="carousel-inner mt-5">
  	<h1 align = "center" style="color:white"> 영화 </h1>
    <div class="carousel-item active">
      <img src="resources/images/movie1.jpg" class="d-block w-100" alt="1">
    </div>
    <div class="carousel-item">
      <img src="resources/images/movie2.jpg" class="d-block w-100" alt="2">
    </div>
    <div class="carousel-item">
      <img src="resources/images/movie3.jpg" class="d-block w-100" alt="3">
    </div>
    <div class="carousel-item">
      <img src="resources/images/movie4.jpg" class="d-block w-100" alt="4">
    </div>
    <div class="carousel-item">
      <img src="resources/images/movie5.jpg" class="d-block w-100" alt="5">
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
</div>
</body>
</html>