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
	   		<a class="nav-link text-dark" href="${pageContext.request.contextPath}/"><b class="font-italic">HOME</b> </a>
	  	</li>
	  <li class="nav-item">
	   <a class="text-success nav-link" href="${pageContext.request.contextPath}/employees/GetEmployeesListServlet"><b>사원</b> 조회</a>
	   <small>
		   <a href="${pageContext.request.contextPath}/employees/GetEmployeesListOrderBy?order=asc">오름차순</a>
		   <a href="${pageContext.request.contextPath}/employees/GetEmployeesListOrderBy?order=desc">내림차순</a>
	   </small>
	  </li>
	  <li class="nav-item">
	    <a class="text-primary nav-link" href="${pageContext.request.contextPath}/departments/GetDepartmentsListServlet"><b>부서</b> 조회</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link disabled" href="#">부서사원 조회</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link disabled" href="#">부장 조회</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link disabled" href="#">직책 조회</a>
	  </li>
	  <li class="nav-item">
	    <a class="nav-link disabled" href="#">연봉 조회</a>
	  </li>
	  <li class="nav-item">
	  	<a class="nav-link disabled font-italic text-secondary small">구현 예정 항목 OFF상태</a>
	  </li>	  
	</ul>
	<hr>
</body>
</html>