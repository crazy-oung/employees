<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<!-- 부트스트랩  -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- Bootstrap icons -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<meta charset="UTF-8">
<title>title List</title>
</head>
<body>
<!-- 페이지 상단 시작 -->
<div class="jumbotron">
	<div class="container">
	  	<h1><i class="fas fa-coffee"> TITLE list@!</i></h1>
	  	<p>employees 샘플 데이터베이스를 사용하여 구현한 웹 프로젝트의 <b class="display-4 font-weight-bold text-danger">직책조회</b> 페이지입니다.</p>
	</div>
</div>
<!-- 페이지 상단 끝 -->
<!-- 페이지 리스트 -->
<jsp:include page="../naveBar.jsp"></jsp:include>
<!-- 페이지 내용 시작 -->
<div class="container">		
	<!-- 직책 종류 리스트 출력 시작  -->
	<ol>
		<table class="table table-hover table-stripped">
			<tr>
				<th>부서명</th>
			</tr>
			<tr>
				<c:forEach var="titles" items="${list}">
					<tr>
						<td>
							<li class="text-dark display-4">		
								${titles}
							</li>
						</td>							
					<tr>
				</c:forEach>
			</tr>
		</table>
	</ol>
	<!-- 직책 종류 리스트 출력 끝  -->
</div>
<!-- 페이지 내용 끝 -->
</body>
</html>