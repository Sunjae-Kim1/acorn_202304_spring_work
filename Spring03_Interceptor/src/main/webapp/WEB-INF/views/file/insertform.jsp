<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/file/insertform.jsp</title>
<style>
	#profileForm{
		display : none;
	}
	#profileLink img{
		width : 200px;
		height : 200px;
		border : 1px solid red;
		border-radius : 50%;
	}
</style>
</head>
<body>
	<div class = "container">
		<h3> 파일 업로드 폼1 </h3>
		<form action = "${pageContext.request.contextPath}/file/upload" method = "post"
			enctype = "multipart/form-data">
			제목 <input type = "text" name = "title"/><br>
			첨부 파일<input type = "file" name = "myFile"/><br>
			<button type = "submit">업로드</button>
		</form>
		
		<h3> 파일 업로드 폼2 </h3>
		<form action = "${pageContext.request.contextPath}/file/upload2" method = "post"
			enctype = "multipart/form-data">
			제목 <input type = "text" name = "title"/><br>
			첨부 파일<input type = "file" name = "myFile"/><br>
			<button type = "submit">업로드</button>
		</form>
		
		<!-- 이미지를 선택해서 업로드 버튼을 누르면 페이지 전환없이 이미지를 업로드 -->
		<!-- 업로드된 파일의 정보를 응답 ( JSON ) 받아서 -->
		<!-- id 가 imageWrapper 인 div 의 자식요소에 img 요소를 추가해서 업로드된 이미지가 바로 보이게 한다. -->
		
		<!-- webapp/resources/upload 폴더에 이미지를 저장 -->
		<!-- gura_util.js 를 webapp/resources/js 폴더에 넣어두고 로딩해서 사용 -->
		
		<h3> 이미지 업로드 폼 </h3>
		<form action = "${pageContext.request.contextPath}/image/upload" method = "post" enctype = "multipart/form-data" id = "uploadForm">
			이미지 <input type = "file" name = "image" accept = ".jpg , .jpeg , .JPG , .JPEG , .gif , .png , .PNG"/><br>
			<button type = "submit">업로드</button>
		</form>
		<br>
		<div id = "imageWrapper"></div>
		
		<div>
			<a id = "profileLink" href = "javascript:">
				프로필
			</a>
		</div>
		
		<form action = "${pageContext.request.contextPath}/image/upload" method = "post"
			enctype = "multipart/form-data" id="profileForm">
			이미지 <input type = "file" name = "image" id = "file" accept = ".jpg , .jpeg , .JPG , .JPEG , .gif , .png , .PNG"/>
		</form>
		
		<!-- -------------------------------------------------------------------------- -->
		
		<script src = "${pageContext.request.contextPath}/resources/js/gura_util.js"></script>
		<script>
				// 프로필 링크를 눌렀을떄 실행할 함수 등록
				document.querySelector("#profileLink").addEventListener("click" , () => {
					// input type = "file" 을 강제 클릭해서 파일 선택창 띄우기
					document.querySelector("#file").click();
				});
				
				// 파일을 선택했을 시 실행할 함수 등록
				document.querySelector("#file").addEventListener("change" , () => {
					// 폼에 입력한 내용을 AJAX 로 제출
					const form = document.querySelector("#profileForm");
					ajaxFormPromise(form)
					.then(res => res.json())
					.then(data => {
						const imgString = `<img src = "${pageContext.request.contextPath}\${data.imagePath}">`;
						document.querySelector("#profileLink").innerHTML = imgString;
					});
				});
				
				document.querySelector("#uploadForm").addEventListener("submit" , (e) => {
					// 폼 전송 막기
					e.preventDefault();
					
					/*
					// gura_util.js 에 있는 함수를 호출하면서 폼의 참조값 전달
					ajaxFormPromise(e.target)
					.then(res => res.json())
					.then(data => {
						
					});
					*/
					
					// gura_util.js 을 사용하지 않는 경우
					// 서버에 전송할 data 를 구성
					let data = new FormData(e.target);
					// fetch() 함수가 리턴하는 Promise 객체를
					fetch("${pageContext.request.contextPath}/image/upload" , {
						method:"post" ,
						body:data
					})
					.then(res => res.json())
					.then(data => {
						// data 는 {imagePath:"resources/upload/xxx"} 형식의 Object 이다.
						const imgString = `<img src = "${pageContext.request.contextPath}\${data.imagePath}">`;
						// img 요소를 표현하고 있는 문자열을 HTML 형식으로 해석이 되도록 대입한다.
						document.querySelector("#imageWrapper").innerHTML = imgString;
					});
				});
		</script>
	</div>
</body>
</html>