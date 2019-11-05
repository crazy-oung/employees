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
<!-- 문자 설정 -->
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body class="bg-light" style="padding-top:10%">
<!-- 페이지 상단 시작 -->
<div class="jumbotron" >
	<div class="container" align="center">
	  	<h1 class="display-3"><i class="fas fa-cloud"> HRMS LOGIN</i></h1>
	  	<hr>
	  	<b>Human Resource Management System LOGIN</b>
	  	<hr>
	  	<!-- 로그인 폼 시작 -->
	  	<form method="post" action="${pageContext.request.contextPath}/login">
	  		<!-- 정보 입력 -->
		  	<div class="d-flex justify-content-center" >
		  		<div><!-- 이름 받기 -->
		  			<b>이름(first name)</b><input name="firstName" class="form-control" value="Georgi">
		  		</div><!-- 이름 끝 -->
		  		<div><!-- 성 받기 -->
		  			 <b>성(last name)</b><input name="lastName" class="form-control" value="Facello">
		  		</div><!-- 성 끝 -->
		  		<div><!-- 사번 받기 -->
		  			<B>사번(emp no)</B><input name="sessionEmpNo" class="form-control" value="10001">
		  		</div><!-- 사번 끝 -->
	  		</div><!-- 정보 입력 끝 -->
	  		<hr>
	  		<button type="submit" class="btn btn-outline-dark">로그인</button>
	  	</form><!-- 로그인 폼 끝 -->
	  	<hr>
	  	<p>employees 샘플 데이터베이스를 사용하여 구현한 웹 프로젝트의 <b class="font-weight-bold h3 text-dark">로그인</b> 페이지입니다.</p>
	
	</div>	
</div><!-- 페이지 상단 끝 -->
</body>
</html>