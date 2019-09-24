<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>title List</title>
</head>
<body>

<div class="jumbotron">
	<div class="container">
	  	<h1><i class="fas fa-coffee"> TITLE list@!@!</i></h1>
	  	<p>employees 샘플 데이터베이스를 사용하여 구현한 웹 프로젝트의 <b class="display-4 font-weight-bold text-danger">직책조회 </b>페이지입니다.</p>
	</div>
</div>

<div class="container">	
	<jsp:include page="../naveBar.jsp"></jsp:include>
	<ol>
		<c:forEach var="titles" items="${list}">
			<li class="text-dark display-4">		
				${titles}
			</li>
		</c:forEach>
	</ol>

</div>

</div>
</body>
</html>