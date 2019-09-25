<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<hr>
	<ul class="nav d-flex justify-content-center">
		<li class="nav-item">
			<a class="nav-link text-dark" href="${pageContext.request.contextPath}/"><b>HOME</b> </a>
		</li>
		<li class="nav-item">
			<a class="text-success nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesList">
				<b>사원</b>조회
				<span class="badge badge-primary badge-pill">대표</span>
			</a>
			<small>
				<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">오름차순</a>
				<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">내림차순</a>
			 </small>
		</li>
		<li class="nav-item">
			<a class="nav-link text-success" href="${pageContext.request.contextPath}/employees/getEmployeesListByPage">
				<b>사원</b>조회
				<span class="badge badge-success badge-pill">페이징</span>
			</a>
		</li>
		<li class="nav-item">
			<a class="nav-link text-success" href="${pageContext.request.contextPath}/employees/getEmployeesCountByGender">
				<b>사원</b>조회
				<span class="badge badge-success badge-pill">성별</span>
			</a>
		</li>
		<li class="nav-item">
			<a class="text-danger nav-link" href="${pageContext.request.contextPath}/titles/getTitlesListDistinct"><b>직책</b>조회</a>
		</li>
		<li class="nav-item">
			<a class="text-info nav-link" href="${pageContext.request.contextPath}/departments/getDepartmentsList"><b>부서</b>조회</a>
		</li>
		<li class="nav-item">
			<a class="nav-link text-info" href="${pageContext.request.contextPath}/departments/getDepartmentsCountByDeptNo"><b>부서사원</b>조회</a>
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

