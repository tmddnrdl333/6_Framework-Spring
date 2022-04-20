<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<a href="${root}/">홈으로 이동</a>

<c:choose>
	<c:when test="${userId == null}">
		<!-- 로그인 안 한 경우 -->
		<div><a href="${root}/user/login_form.do">로그인</a><a>회원가입</a></div>
	</c:when>
	<c:otherwise>
		<!-- 로그인 한 경우 -->
		<div>
			<c:if test="${userProfile != null}">
				<img src="${root}/img/profile/${userProfile}" width="100px" height="100px" />
			</c:if>
			
			${userName}님 로그인중!! 
			<a href="${root}/user/logout.do">로그아웃</a>
			<a href="${root}/user/profile_form.do">프로필 수정</a>
		</div>
	</c:otherwise>
</c:choose>
<hr/>    