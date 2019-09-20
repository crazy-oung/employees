<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>departments List</title>
</head>
<body>
<div class="jumbotron">
	<div class="container">
	  	<h1><i class="fas fa-coffee"> DEPT list@!</i></h1>
	  	<p>employees 샘플 데이터베이스를 사용하여 구현한 웹 프로젝트의 <b class="display-4 font-weight-bold text-primary">부서조회</b> 페이지입니다.</p>
	</div>
</div>
<div class="container">
	<hr>
	<jsp:include page="../naveBar.jsp"></jsp:include>	
	<hr>
	<table class="table table-bordered table-hover table-striped"  style="text-align:center;">
	<thead>
		<tr>
			<td width="20%">부서번호</td>
			<td>부서이름</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="departments" items="${list}">
			<tr>			
				<td>${departments.deptNo}</td>
				<td>${departments.deptName}</td>				
			</tr>
		</c:forEach>
	</tbody>
	</table>
</div>	
</body>
</html>