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
<title>employees List</title>
</head>
<body>
<div class="jumbotron">
	<div class="container">
	  	<h1><i class="fas fa-coffee"> EMP list@!</i></h1>
	  	<p>employees 샘플 데이터베이스를 사용하여 구현한 웹 프로젝트의 <b class="display-4 font-weight-bold text-success">사원조회</b> 페이지입니다.</p>
	</div>
</div>

<div class="container">

	<jsp:include page="../naveBar.jsp"></jsp:include>	

	<h4>선택한 개수만큼 출력</h4>	
	<form action="${pageContext.request.contextPath}/employees/GetEmployeesList" method="get">
		<!-- 출력 개수 제한 선택 -->
		<div class="d-flex">
		<select name="limit" class="custom-select" style="width:30%">
			<option value="30" checked>30</option>
			<option value="50">50</option>
			<option value="70">70</option>
			<option value="100">100</option>
		</select>		
		<button class="btn btn-warning" type="submit">검색</button>
		</div>
	</form>
	<hr>
	<table class="table table-bordered table-hover table-striped"  style="text-align:center;">
	<thead>
		<tr>
			<th width="10%">사원번호</th>
			<th>이름</th>
			<th>성</th>
			<th width="14%">생일</th>
			<th width="7%">성별</th>
			<th width="14%">입사일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="employees" items="${list}">
			<tr>			
				<td>${employees.empNo}</td>
				<td>${employees.empFirstName}</td>
				<td>${employees.empLastName}</td>
				<td>${employees.birthDate}</td>
				<td>${employees.gender}</td>
				<td>${employees.hireDate}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</div>

</body>
</html>