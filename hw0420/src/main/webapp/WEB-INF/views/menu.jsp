<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div><a href="${root}/">홈으로</a></div>
<c:choose>
	<c:when test="${userId == null}">
		<!-- 로그인 안된 경우 -->
		<form action="${root}/user/login.do" method="post">
			ID : <input type="text" placeholder="아이디를 입력하세요" name="id" />
			PW : <input type="password" placeholder="비밀번호를 입력하세요" name="pass" />
			<input type="submit" value="로그인">
		</form>
	</c:when>
	<c:otherwise>
		${userName}님안녕하세요!
		<a href="${root}/user/logout.do">로그아웃</a>
	</c:otherwise>
</c:choose>
<hr/>