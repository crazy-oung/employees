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
	  	<h1><i class="fas fa-coffee"> DEPT EMP list@!</i></h1>
	  	<p>employees 샘플 데이터베이스를 사용하여 구현한 웹 프로젝트의 <b class="display-4 font-weight-bold text-info">부서사원</b>조회 페이지입니다.</p>
	</div>
</div><!-- 페이지 상단 끝 -->
<!-- 리스트 -->
<jsp:include page="../naveBar.jsp"></jsp:include>
<!-- 페이지 내용(메인) -->
<div class="container">	
	<!-- 폼 시작 -->
	<form action="${pageContext.request.contextPath}/departmentEmployees/getDeptEmpListByPage" method="get">
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
			<th width="10%">부서번호</th>
			<th>부서이름</th>
			<th width="14%">사원번호</th>
			<th>이름</th>
			<th>성</th>
			<th width="14%">근무시작일</th>
			<th width="14%">근무종료일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="deptEmp" items="${list}">
			<tr>			
				<td>${deptEmp.department.deptNo}</td>
				<td>${deptEmp.department.deptName}</td>
				<td>${deptEmp.employees.empNo}</td>
				<td>${deptEmp.employees.firstName}</td>
				<td>${deptEmp.employees.lastName}</td>
				<td>${deptEmp.fromDate}</td>
				<td>${deptEmp.toDate}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<!-- 테이블 끝 -->
	<hr>
	<!-- 페이징 시작 -->
	<div align="center">
		<!-- 이전 버튼 출력 -->
		<c:if test="${currentPage > 1 }">
			<a href="${pageContext.request.contextPath}/departmentEmployees/getDeptEmpListByPage?currentPage=${currentPage -1}&rowPerPage=${rowPerPage}">
				이전
			</a>
		</c:if><!-- 이전버튼 끝 -->
		<!-- 앞 번호 출력 -->
		<c:if test="${currentPage > 5 }">
			<c:forEach var="page" begin="${currentPage-4}" end="${currentPage-1}" step="1">
				<a href="${pageContext.request.contextPath}/departmentEmployees/getDeptEmpListByPage?currentPage=${page}&rowPerPage=${rowPerPage}">
					${page}
				</a>
			</c:forEach>			
		</c:if><!-- 앞 버튼 출력 끝 -->
		<!-- 현재 페이지 -->
		<a href="${pageContext.request.contextPath}/departmentEmployees/getDeptEmpListByPage?currentPage=${page}&rowPerPage=${rowPerPage}">
			<b>${currentPage}</b>
		</a>
		<!-- 뒷 번호 출력 -->
		<c:forEach var="page" begin="${currentPage+1}" end="${currentPage +4}" step="1">
			<a href="${pageContext.request.contextPath}/departmentEmployees/getDeptEmpListByPage?currentPage=${page}&rowPerPage=${rowPerPage}">
				${page}
			</a>
		</c:forEach>
		<c:if test="${currentPage < lastPage }">
			<a href="${pageContext.request.contextPath}/employees/getDeptEmpListByPage?currentPage=${currentPage +1}&rowPerPage=${rowPerPage}">
				다음
			</a>
		</c:if>
	</div>
	<!-- 페이징 끝 -->
	<hr>
</div>
</body>
</html>