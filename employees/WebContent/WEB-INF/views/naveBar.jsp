<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<!-- Bootstrap icons -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" 
integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
<!-- charSet -->
<meta charset="UTF-8">
</head>
<body>
	<hr>
	<ul class="nav">
		<li class="nav-item">
	   		<a class="nav-link text-dark" href="${pageContext.request.contextPath}/"><b>HOME</b> </a>
	  	</li>
	  <li class="nav-item">
	   <a class="text-success nav-link" href="${pageContext.request.contextPath}/employees/GetEmployeesList"><b>사원</b>조회</a>
	   <small>
		   <a href="${pageContext.request.contextPath}/employees/GetEmployeesListOrderBy?order=asc">오름차순</a>
		   <a href="${pageContext.request.contextPath}/employees/GetEmployeesListOrderBy?order=desc">내림차순</a>
	   </small>
	  </li>
	  <li class="nav-item">
	    <a class="text-primary nav-link" href="${pageContext.request.contextPath}/departments/GetDepartmentsList"><b>부서</b>조회</a>
	  </li>
	  <li class="nav-item">
	    <a class="text-danger nav-link" href="${pageContext.request.contextPath}/titles/titlesListDistinct"><b>직책</b>조회</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link disabled" href="#">부서사원조회</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link disabled" href="#">부장조회</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link text-warning" href="${pageContext.request.contextPath}/salaries/getSalariesStatistics"><b>연봉</b>집계</a>
	  </li>
	  <li class="nav-item">
	  	<a class="nav-link disabled font-italic text-secondary small">구현예정항목 disabled</a>
	  </li>	  
	</ul>
	<hr>
</body>
</html>