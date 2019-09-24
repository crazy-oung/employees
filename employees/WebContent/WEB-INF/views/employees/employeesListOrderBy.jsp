<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employees List</title>
</head>
<body>
<div class="jumbotron">
	<div class="container">
	  	<h1><i class="fas fa-coffee"> EMP list@ 정렬!</i></h1>
	  	<p>employees 샘플 데이터베이스를 사용하여 구현한 웹 프로젝트의 <b class="display-4 font-weight-bold text-success">사원조회 데이터가 정렬</b>된 페이지입니다.</p>
	</div>
</div>
<div class="container">

	<jsp:include page="../naveBar.jsp"></jsp:include>

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
</div>
</body>
</html>