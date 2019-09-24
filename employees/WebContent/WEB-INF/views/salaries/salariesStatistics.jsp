<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>salaries statistics</title>
</head>
<body>

<div class="jumbotron">
	<div class="container">
	  	<h1><i class="fas fa-coffee"> SALARIES statictics@!</i></h1>
	  	<p>employees 샘플 데이터베이스를 사용하여 구현한 웹 프로젝트의 <b class="display-4 font-weight-bold text-warning">연봉집계</b> 페이지입니다.</p>
	</div>
</div>
<div class="container">
	<jsp:include page="../naveBar.jsp"></jsp:include>
	
	<table class="table table-bordered table-hover table-striped"  style="text-align:center;">
	<thead>
		<tr>
			<th>데이터 수</th>
			<th>최소</th>
			<th>최대</th>
			<th>합</th>
			<th>평균</th>
			<th>표준편차</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="map" items="${map}">
			<tr>			
				<td>${map.count}</td>
				<td>${map.min}</td>
				<td>${map.max}</td>
				<td>${map.sum}</td>
				<td>${map.avg}</td>
				<td>${map.std}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</div>

</body>
</html>