<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/movie/upload_form</title>
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
	.btn{
		width: 25%;
	}
	#preview{
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
		<h1 style = "color:white" align = "center">Upload Page</h1>
		<form action="${pageContext.request.contextPath}/movie/upload" method="post" enctype="multipart/form-data">
		
		<table id = "table" class="table table-light table-striped mt-5">
			<tbody>
				<tr>
					<th>
						<label for="caption">Title</label>
					</th>
					<td>
						<input type="text" name="caption" id="caption"/>
					</td>
				</tr>
				<tr>
					<th>
						<label for="image">Movie Image</label>
					</th>
					<td>
						<input type="file" name="image" id="image" accept = ".jpg , .jpeg , .png , .JPG , .JPEG"/>
					</td>
				</tr>
				<tr>
					<td colspan = "2">
						<img alt = "Preview" id = "preview"/>
					</td>
				</tr>
			</tbody>
		</table>
		<div align = "center">
			<button class = "btn btn-primary mt-3" type="submit">Upload</button>
		</div>
		</form>
	</div>
	<script>
		document.querySelector("#image").addEventListener("change" , (e) => {
			// 선택된 파일 객체를 얻어낸다.
			const files = e.target.files;
			console.log(files);
			// 만일 파일이 존재한다면
			if(files.length > 0){
				// 파일로부터 데이터를 읽어올 객체
				const reader = new FileReader();
				// 로딩이 완료 ( 파일 데이터를 모두 읽었을 때 ) 되었을때 실행할 함수 등록
				reader.onload = (event) => {
					// 읽은 파일 데이터 얻어오기
					const data = event.target.result;
					// console.log(data);
					document.querySelector("#preview").setAttribute("src" , data);
				};
				// 파일을 DataURL 형식의 문자열로 읽어내기
				reader.readAsDataURL(files[0]);
			}
		});
	</script>
</body>
</html>