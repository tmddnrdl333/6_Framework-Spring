<%@ page import="com.ssafy.hw0420.model.dto.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookList</title>
</head>
<body>
	<jsp:include page="/WEB-INF/views/menu.jsp"></jsp:include>
	
	<h1>도서 목록 조회</h1>
	<table>
		<thead>
			<tr>
				<th>도서 번호</th>
				<th>도서 이름</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${not empty bookList}">
					<c:forEach items="${bookList}" var="book">
						<tr>
							<td>${book.isbn}</td>
							<td>${book.title}</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="2">등록된 도서 정보가 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
	
	
</body>
</html>