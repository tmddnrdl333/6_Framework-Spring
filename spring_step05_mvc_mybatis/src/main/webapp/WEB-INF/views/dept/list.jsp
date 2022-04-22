<%@page import="com.ssafy.myapp.model.dto.Dept"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${root}/css/table1.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>	
	<h1>부서 목록</h1>
	
	<form action="${root}/dept/search" method="post">
		부서명 : <input type="text" name="dName" value="${param.dName}"/>
		지역 : <input type="text" name="loc" value="${param.loc}"/>
		<input type="submit" value="검색"/>
	</form>
	
	<table>
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서이름</th>
			</tr>
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${not empty deptList}">
				<c:forEach items="${deptList}" var="dept">
					<tr>
						<td>${dept.deptNo}</td>
						<td><a href="${root}/dept/detail.do?deptNo=${dept.deptNo}">${dept.dName}</a></td>
					</tr>
				</c:forEach>			
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="2">등록된 부서 정보가 없습니다.</td>
				</tr>						
			</c:otherwise>
		</c:choose>
		
		

		</tbody>
	</table>
</body>
</html>