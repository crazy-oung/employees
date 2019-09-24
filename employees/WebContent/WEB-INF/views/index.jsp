<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<title>Index - HOME</title>
</head>
<body>
<div class="jumbotron">
	<div class="container">
	  	<h1><i class="fas fa-coffee"> Index@!</i></h1>
	  	<p>employees 샘플 데이터베이스를 사용하여 구현한 웹 프로젝트의 <b class="display-4 font-weight-bold text-dark">메인</b> 페이지입니다.</p>
	</div>
</div>

<div class="container">
	<hr>
	<div>
		<b>표현식 --></b> employees total row count: <%= request.getAttribute("employeesRowCount") %><br>
		<b>EL표현식 --></b> employee table row count : ${employeesRowCount};

	<jsp:include page="./naveBar.jsp"></jsp:include>	

	<h4><b>테이블 정보 </b></h4>
  	<div>
  		<table class="table table-bordered table-hover"  style="text-align:center;">
  			<thead>
	  			<tr>
	  				<th>테이블 이름</th>
	  				<th>데이터 개수</th>
	  			</tr>
  			</thead>
  			<tbody>
  				<tr>
  					<td>departments</td>
	  				<td>${departmentsRowCount}</td>	  				
  				</tr>
  				<tr>
  					<td>employees</td>
	  				<td>${employeesRowCount}</td>	  				
  				</tr>
  				<tr>
  					<td>titles</td>
	  				<td>${titlesRowCount}</td>	  				
  				</tr>
  				<tr>
  					<td>emp_manger</td>
	  				<td>${deptManagerRowCount}</td>	  				
  				</tr>
  				<tr>
  					<td>dept_emp</td>
	  				<td>${deptEmpRowCount}</td>	  			
	  					
  				</tr>
  				<tr>
  					<td>salaries</td>
	  				<td>${salariesRowCount}</td>	  				
  				</tr>
  			</tbody>
  		</table>
  	
  	</div>
	</div>
</div>
</body>
</html>