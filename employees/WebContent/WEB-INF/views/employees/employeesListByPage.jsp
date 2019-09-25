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
<!-- charSet -->
<meta charset="UTF-8">
<title>employeesList By page</title>
</head>
<body>
<!-- 페이지 상단 -->
<div class="jumbotron">
	<div class="container">
	  	<h1><i class="fas fa-coffee"> EMP list@ paging!</i></h1>
	  	<p>employees 샘플 데이터베이스를 사용하여 구현한 웹 프로젝트의 <b class="display-4 font-weight-bold text-success">사원조회<small><b>(페이징)</b></small></b> 페이지입니다.</p>
	</div>
</div><!-- 페이지 상단 끝 -->
<!-- 리스트 -->
<jsp:include page="../naveBar.jsp"></jsp:include>
<!-- 페이지 내용(메인) -->
<div class="container">	
	<!-- 폼 시작 -->
	<form action="${pageContext.request.contextPath}/employees/getEmployeesListByPage" method="get">
		<!-- 출력 개수 제한 선택 -->		
		<div class="d-flex justify-content-end">
			<select name="rowPerPage" class="custom-select" style="width: 6%">
				<option value="5" checked>5</option>
				<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
				<option value="30">30</option>
				<option value="40">40</option>
				<option value="50">50</option>
			</select>
			<button class="btn btn-warning" type="submit">검색</button>
		</div>
	</form>
	<!-- 폼 끝 -->
	<!-- 테이블 시작 -->
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
				<td>${employees.firstName}</td>
				<td>${employees.lastName}</td>
				<td>${employees.birthDate}</td>
				<td>${employees.gender}</td>
				<td>${employees.hireDate}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<!-- 테이블 끝 -->
	<hr>
	<!-- 페이징 시작 -->
	<div align="center">
		<c:if test="${currentPage > 1 }">
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage -1}&rowPerPage=${rowPerPage}">
				이전
			</a>
		</c:if>
		<c:forEach var="page" begin="${currentPage}" end="${currentPage +9}" step="1">
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${page}&rowPerPage=${rowPerPage}">
				${page}
			</a>
		</c:forEach>
		<c:if test="${currentPage < lastPage }">
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage +1}&rowPerPage=${rowPerPage}">
				다음
			</a>
		</c:if>
	</div>
	<!-- 페이징 끝 -->
	<hr>
</div>
</body>
</html>