<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="p-1 bg-white">
	<div class="container">
		<div class="d-flex flex-wrap align-items-center justify-content-end ">
			<div class="col-md-12 justify-content-end">
				<c:choose>
					<c:when test="${msg != null}">
						<script type="text/javascript">
							alert("${msg}");
						</script>
					</c:when>
				</c:choose>
				<c:choose>
					<%-- <c:when test="${memberInfo == null}"> --%>
					<c:when test="${empty sessionScope.memberInfo}">
						<button type="button" class="btn btn-outline-dark me-2"
							data-toggle="modal" data-target="#loginModal">Login</button>
						<a href="#" type="button" class="btn btn-outline-info me-2"
							data-toggle="modal" data-target="#registModal">Sign up</a>
					</c:when>
					<c:otherwise>
						<a href="${root}/user/logout" type="button"
							class="btn btn-outline-dark me-2">Logout</a>
						<a href="#" type="button" class="btn btn-outline-info me-2">회원정보</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</header>
<div class="container">
	<header id="index_header" class="jumbotron text-center mb-1">
		<img id="logo" src="/img/happyhouse.png">
	</header>
	<!-- nav start -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark rounded">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbardrop"
				data-toggle="dropdown"> 동네 정보 </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">APT 매매</a> <a
						class="dropdown-item" href="#">APT 전월세</a> <a
						class="dropdown-item" href="#">주택 매매</a> <a class="dropdown-item"
						href="#">주택 전월세</a> <a class="dropdown-item" href="#">상권 정보</a> <a
						class="dropdown-item" href="#">환경 정보</a>
				</div></li>
			<li class="nav-item"><a class="nav-link" href="#">Notice</a></li>
			<li class="nav-item"><a class="nav-link" href="#">News</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
		</ul>
	</nav>