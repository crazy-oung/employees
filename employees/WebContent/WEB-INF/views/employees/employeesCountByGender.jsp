<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="jumbotron">
	<div class="container">
	  	<h1><i class="fas fa-coffee"> EMP list@ searched by gender!</i></h1>
	  	<p>employees 샘플 데이터베이스를 사용하여 구현한 웹 프로젝트의 <b class="display-4 font-weight-bold text-success">성별 사원조회</b> 페이지입니다.</p>
	</div>
</div>

<div class="container">
	<!-- 상단 리스트 -->
	<jsp:include page="../naveBar.jsp"></jsp:include>	
	
	<table class="table table-bordered table-hover table-striped"  style="text-align:center;">
		<thead>
			<tr>
				<th>성별</th>
				<th>명수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var = "employees" items = "${list}">
				<tr>
					<td>${employees.gender}</td>
					<td>${employees.cnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>