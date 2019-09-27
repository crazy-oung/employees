<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<hr>
	<ul class="nav d-flex justify-content-center" align="center">
		<li class="nav-item">
			<a class="nav-link text-dark" href="${pageContext.request.contextPath}/"><b>HOME</b> </a>
		</li>
		<!-- 사원조회 -->
		<li class="nav-item">
			<a class="text-success nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesList">
				<b>사원</b>조회
				<span class="badge badge-danger badge-pill">*</span>
			</a>
			<!-- 사원 목록 오름차순 보기 버튼 -->
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">
				<span class="badge badge-primary badge-pill">오름차순</span>
			</a>
			<!-- 사원 목록 내림차순 보기 버튼 -->
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">
				<span class="badge badge-primary badge-pill">내림차순</span>
			</a>			
		</li><!-- 사원 조회 끝 -->
		<!-- 사원  페이징 조회-->
		<li class="nav-item">
			<a class="nav-link text-success" href="${pageContext.request.contextPath}/employees/getEmployeesListByPage">
				<b>사원</b>조회
				<span class="badge badge-success badge-pill">페이징</span>
			</a>
		</li><!-- 사원  페이징 조회 끝-->
		<!-- 사원  성별 조회 -->
		<li class="nav-item">
			<a class="nav-link text-success" href="${pageContext.request.contextPath}/employees/getEmployeesCountByGender">
				<b>사원</b>조회
				<span class="badge badge-success badge-pill">성별</span>
			</a>
		</li><!-- 사원  성별 조회 끝 -->
		<!-- 직책 조회 -->
		<li class="nav-item">
			<a class="text-danger nav-link" href="${pageContext.request.contextPath}/titles/getTitlesListDistinct"><b>직책</b>조회</a>
		</li><!-- 직책 조회 끝 -->
		<!-- 부서 조회 -->
		<li class="nav-item">
			<a class="text-info nav-link" href="${pageContext.request.contextPath}/departments/getDepartmentsList"><b>부서</b>조회</a>
		</li><!-- 부서 조회 끝 -->
		<!-- 부서사원 조회  -->
		<li class="nav-item">
			<a class="nav-link text-info" href="${pageContext.request.contextPath}/departmentEmployees/getDeptEmpListByPage"><b>부서사원</b>조회</a>
			<!-- 부서 사원 수 보기 버튼 -->  
			<a href="${pageContext.request.contextPath}/departments/getDepartmentsCountByDeptNo">
				<span class="badge badge-primary badge-pill">부서 현황</span>
			</a><!-- 부서 사원 수 보기 버튼 끝 -->
		</li><!-- 부서사원 조회 끝 -->
		<!-- 부장 조회 -->
		<li class="nav-item">
			<a class="nav-link disabled" href="#">부장조회</a>
		</li><!-- 부장 조회 끝 -->
		<!-- 연봉 조회 -->
		<li class="nav-item">
			<a class="nav-link text-warning" href="${pageContext.request.contextPath}/salaries/getSalariesStatistics"><b>연봉</b>집계</a>
		</li><!-- 연봉조회 끝 -->
		<!-- 로그아웃 -->
		<c:if test="${sessionEmpNo != null}">
			<li class="nav-item">
				<a class="nav-link text-dark font-weight-bold" href="${pageContext.request.contextPath}/logout">로그아웃</a>
			</li>
		</c:if><!-- 로그아웃 끝-->
		<!-- 구현예정항목 안내 -->
		<li class="nav-item">
			<a class="nav-link disabled text-ligth font-italic text-secondary small">구현예정항목 disabled</a>
		</li>	  
	</ul>
<hr>

